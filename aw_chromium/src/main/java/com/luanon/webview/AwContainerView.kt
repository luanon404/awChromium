package com.luanon.webview

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Canvas
import android.graphics.PixelFormat
import android.graphics.Rect
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.view.DragEvent
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View
import android.view.accessibility.AccessibilityNodeProvider
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection
import android.widget.FrameLayout
import org.chromium.android_webview.AwContents
import org.chromium.android_webview.AwContents.NativeDrawGLFunctor
import org.chromium.android_webview.gfx.AwDrawFnImpl
import org.chromium.android_webview.shell.ContextManager
import org.chromium.base.Callback
import org.chromium.content_public.browser.WebContents

@SuppressLint("ViewConstructor")
class AwContainerView(context: Context, allowHardwareAcceleration: Boolean) : FrameLayout(context) {
    var awContents: AwContents? = null
        private set
    val internalAccessDelegate: AwContents.InternalAccessDelegate
    private var mHardwareView: HardwareView? = null
    private var mAttachedContents = false
    private var mWindowVisibleDisplayFrameOverride: Rect? = null

    private class WaitableEvent {
        private val mLock = Object()
        private var mSignaled = false
        fun waitForEvent() {
            synchronized(mLock) {
                while (!mSignaled) {
                    try {
                        mLock.wait()
                    } catch (e: InterruptedException) {
                        throw RuntimeException(e)
                    }
                }
            }
        }

        fun signal() {
            synchronized(mLock) {
                assert(!mSignaled)
                mSignaled = true
                mLock.notifyAll()
            }
        }
    }

    private inner class HardwareView(context: Context?) : SurfaceView(context),
        SurfaceHolder.Callback {
        // Only accessed on UI thread.
        private var mWidth = 0
        private var mHeight = 0
        private var mLastScrollX = 0
        private var mLastScrollY = 0
        var isReadyToRender = false
            private set
        private var mReadyToRenderCallback: Runnable? = null
        val overlaysView: SurfaceView

        // Only accessed on render thread.
        private val mContextManager: ContextManager

        init {
            if (sRenderThread == null) {
                sRenderThread = HandlerThread("RenderThreadInstr")
                sRenderThread!!.start()
                sRenderThreadHandler = Handler(sRenderThread!!.looper)
            }
            mContextManager = ContextManager()
            holder.setFormat(PixelFormat.TRANSPARENT)
            holder.addCallback(this)

            // Main SurfaceView needs to be positioned above the media content.
            setZOrderMediaOverlay(true)
            overlaysView = SurfaceView(context)
            overlaysView.holder.addCallback(this)

            // This SurfaceView is used to present media and must be positioned below main surface.
            overlaysView.setZOrderMediaOverlay(false)
        }

        fun readbackQuadrantColors(callback: Callback<IntArray?>) {
            sRenderThreadHandler!!.post {
                callback.onResult(
                    mContextManager.draw(
                        mWidth, mHeight, mLastScrollX, mLastScrollY, true
                    )
                )
            }
        }

        fun setReadyToRenderCallback(runner: Runnable?) {
            assert(!isReadyToRender || runner == null)
            mReadyToRenderCallback = runner
        }

        override fun surfaceCreated(holder: SurfaceHolder) {}
        override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
            if (holder === overlaysView.holder) {
                val surface = holder.surface
                sRenderThreadHandler!!.post {
                    mContextManager.setOverlaysSurface(
                        surface
                    )
                }
                return
            }
            mWidth = width
            mHeight = height
            isReadyToRender = true
            val surface = holder.surface
            sRenderThreadHandler!!.post {
                mContextManager.setSurface(
                    surface, width, height
                )
            }
            if (mReadyToRenderCallback != null) {
                mReadyToRenderCallback!!.run()
                mReadyToRenderCallback = null
            }
        }

        override fun surfaceDestroyed(holder: SurfaceHolder) {
            if (holder === overlaysView.holder) {
                val event = WaitableEvent()
                sRenderThreadHandler!!.post {
                    mContextManager.setOverlaysSurface(null)
                    event.signal()
                }
                event.waitForEvent()
                return
            }
            isReadyToRender = false
            val event = WaitableEvent()
            sRenderThreadHandler!!.post {
                mContextManager.setSurface(null, 0, 0)
                event.signal()
            }
            event.waitForEvent()
        }

        fun updateScroll(x: Int, y: Int) {
            mLastScrollX = x
            mLastScrollY = y
        }

        fun drawWebViewFunctor(functor: Int) {
            if (!isReadyToRender) {
                return
            }
            val syncEvent = WaitableEvent()
            sRenderThreadHandler!!.post {
                drawOnRt(
                    syncEvent, functor, mWidth, mHeight, mLastScrollX, mLastScrollY
                )
            }
            syncEvent.waitForEvent()
        }

        private fun drawOnRt(
            syncEvent: WaitableEvent,
            functor: Int,
            width: Int,
            height: Int,
            scrollX: Int,
            scrollY: Int
        ) {
            mContextManager.sync(functor, false)
            syncEvent.signal()
            mContextManager.draw(width, height, scrollX, scrollY, false)
        }
    }

    private fun createHardwareViewOnlyOnce(context: Context): HardwareView? {
        if (sCreatedOnce) return null
        sCreatedOnce = true
        return HardwareView(context)
    }

    init {
        if (allowHardwareAcceleration) {
            mHardwareView = createHardwareViewOnlyOnce(context)
        }
        if (isBackedByHardwareView) {
            addView(
                mHardwareView!!.overlaysView, LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT
                )
            )
            addView(
                mHardwareView, LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT
                )
            )
        } else {
            setLayerType(LAYER_TYPE_SOFTWARE, null)
        }
        internalAccessDelegate = InternalAccessAdapter()
        overScrollMode = OVER_SCROLL_ALWAYS
        isFocusable = true
        isFocusableInTouchMode = true
    }

    fun initialize(awContents: AwContents?) {
        this.awContents = awContents
    }

    override fun getWindowVisibleDisplayFrame(outRect: Rect) {
        if (mWindowVisibleDisplayFrameOverride != null) {
            outRect.set(mWindowVisibleDisplayFrameOverride!!)
        } else {
            super.getWindowVisibleDisplayFrame(outRect)
        }
    }

    val isBackedByHardwareView: Boolean
        get() = mHardwareView != null

    val webContents: WebContents
        @SuppressLint("VisibleForTests") get() = awContents!!.webContents
    val nativeDrawFunctorFactory: AwContents.NativeDrawFunctorFactory
        get() = NativeDrawFunctorFactory()

    fun destroy() {
        awContents!!.destroy()
    }

    public override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        awContents!!.onConfigurationChanged(newConfig)
    }

    private fun attachedContentsInternal() {
        assert(!mAttachedContents)
        awContents!!.onAttachedToWindow()
        mAttachedContents = true
    }

    public override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        if (mHardwareView == null || mHardwareView!!.isReadyToRender) {
            attachedContentsInternal()
        } else {
            mHardwareView!!.setReadyToRenderCallback { attachedContentsInternal() }
        }
    }

    public override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        if (mAttachedContents) {
            awContents!!.onDetachedFromWindow()
            mAttachedContents = false
        }
    }

    public override fun onFocusChanged(
        focused: Boolean, direction: Int, previouslyFocusedRect: Rect?
    ) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect)
        awContents!!.onFocusChanged(focused, direction, previouslyFocusedRect)
    }

    override fun onCreateInputConnection(outAttrs: EditorInfo): InputConnection? {
        return awContents?.onCreateInputConnection(outAttrs)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
        return awContents!!.onKeyUp(keyCode, event)
    }

    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        return awContents!!.dispatchKeyEvent(event)
    }

    public override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        awContents!!.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    public override fun onSizeChanged(w: Int, h: Int, ow: Int, oh: Int) {
        super.onSizeChanged(w, h, ow, oh)
        awContents!!.onSizeChanged(w, h, ow, oh)
    }

    public override fun onOverScrolled(
        scrollX: Int, scrollY: Int, clampedX: Boolean, clampedY: Boolean
    ) {
        awContents!!.onContainerViewOverScrolled(scrollX, scrollY, clampedX, clampedY)
    }

    public override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        super.onScrollChanged(l, t, oldl, oldt)
        if (awContents != null) {
            awContents!!.onContainerViewScrollChanged(l, t, oldl, oldt)
        }
    }

    override fun computeScroll() {
        awContents!!.computeScroll()
    }

    public override fun onVisibilityChanged(changedView: View, visibility: Int) {
        super.onVisibilityChanged(changedView, visibility)
        awContents!!.onVisibilityChanged(changedView, visibility)
    }

    public override fun onWindowVisibilityChanged(visibility: Int) {
        super.onWindowVisibilityChanged(visibility)
        awContents!!.onWindowVisibilityChanged(visibility)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(ev: MotionEvent): Boolean {
        super.onTouchEvent(ev)
        return awContents!!.onTouchEvent(ev)
    }

    override fun onGenericMotionEvent(ev: MotionEvent): Boolean {
        super.onGenericMotionEvent(ev)
        return awContents!!.onGenericMotionEvent(ev)
    }

    override fun onHoverEvent(ev: MotionEvent): Boolean {
        super.onHoverEvent(ev)
        return awContents!!.onHoverEvent(ev)
    }

    public override fun onDraw(canvas: Canvas) {
        if (isBackedByHardwareView) {
            mHardwareView!!.updateScroll(scrollX, scrollY)
        }
        awContents!!.onDraw(canvas)
        super.onDraw(canvas)
    }

    override fun getAccessibilityNodeProvider(): AccessibilityNodeProvider {
        val provider = awContents!!.accessibilityNodeProvider
        return provider ?: super.getAccessibilityNodeProvider()
    }

    override fun performAccessibilityAction(action: Int, arguments: Bundle?): Boolean {
        return awContents!!.performAccessibilityAction(action, arguments)
    }

    override fun onDragEvent(event: DragEvent): Boolean {
        return awContents!!.onDragEvent(event)
    }

    private inner class NativeDrawFunctorFactory : AwContents.NativeDrawFunctorFactory {
        override fun createGLFunctor(context: Long): NativeDrawGLFunctor? {
            return null
        }

        override fun getDrawFnAccess(): AwDrawFnImpl.DrawFnAccess {
            return DrawFnAccess()
        }
    }

    private inner class DrawFnAccess : AwDrawFnImpl.DrawFnAccess {
        override fun drawWebViewFunctor(canvas: Canvas, functor: Int) {
            assert(isBackedByHardwareView)
            mHardwareView!!.drawWebViewFunctor(functor)
        }
    }

    // TODO: AwContents could define a generic class that holds an implementation similar to
    // the one below.
    private inner class InternalAccessAdapter : AwContents.InternalAccessDelegate {
        override fun super_onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
            return super@AwContainerView.onKeyUp(keyCode, event)
        }

        override fun super_dispatchKeyEvent(event: KeyEvent): Boolean {
            return super@AwContainerView.dispatchKeyEvent(event)
        }

        override fun super_onGenericMotionEvent(event: MotionEvent): Boolean {
            return super@AwContainerView.onGenericMotionEvent(event)
        }

        override fun onScrollChanged(lPix: Int, tPix: Int, oldlPix: Int, oldtPix: Int) {
            super@AwContainerView.onScrollChanged(lPix, tPix, oldlPix, oldtPix)
        }

        override fun super_onConfigurationChanged(newConfig: Configuration) {
            super@AwContainerView.onConfigurationChanged(newConfig)
        }

        override fun super_scrollTo(scrollX: Int, scrollY: Int) {
            // We're intentionally not calling super.scrollTo here to make testing easier.
            this@AwContainerView.scrollTo(scrollX, scrollY)
            if (isBackedByHardwareView) {
                // Undo the scroll that will be applied because of mHardwareView
                // being a child of |this|.
                mHardwareView!!.translationX = scrollX.toFloat()
                mHardwareView!!.translationY = scrollY.toFloat()
            }
        }

        override fun setMeasuredDimension(measuredWidth: Int, measuredHeight: Int) {
            super@AwContainerView.setMeasuredDimension(measuredWidth, measuredHeight)
        }

        override fun overScrollBy(
            deltaX: Int,
            deltaY: Int,
            scrollX: Int,
            scrollY: Int,
            scrollRangeX: Int,
            scrollRangeY: Int,
            maxOverScrollX: Int,
            maxOverScrollY: Int,
            isTouchEvent: Boolean
        ) {
            // We're intentionally not calling super.scrollTo here to make testing easier.
            this@AwContainerView.overScrollBy(
                deltaX,
                deltaY,
                scrollX,
                scrollY,
                scrollRangeX,
                scrollRangeY,
                maxOverScrollX,
                maxOverScrollY,
                isTouchEvent
            )
        }

        override fun super_getScrollBarStyle(): Int {
            return super@AwContainerView.getScrollBarStyle()
        }

        override fun super_startActivityForResult(intent: Intent, requestCode: Int) {}
    }


    companion object {
        private var sRenderThread: HandlerThread? = null
        private var sRenderThreadHandler: Handler? = null
        private var sCreatedOnce = false

        fun installDrawFnFunctionTable(useVulkan: Boolean) {
            AwDrawFnImpl.setDrawFnFunctionTable(ContextManager.getDrawFnFunctionTable(useVulkan))
        }
    }

}