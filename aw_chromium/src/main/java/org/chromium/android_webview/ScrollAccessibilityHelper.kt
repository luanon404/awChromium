// Copyright 2013 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.
package org.chromium.android_webview

import android.os.Handler
import android.os.Message
import android.view.View
import android.view.accessibility.AccessibilityEvent

/**
 * Helper used to post the VIEW_SCROLLED accessibility event.
 *
 * TODO(mkosiba): Investigate whether this is behavior we want to share with the chrome/ layer.
 * TODO(mkosiba): We currently don't handle JS-initiated scrolling for layers other than the root
 * layer.
 */
internal class ScrollAccessibilityHelper(eventSender: View) {

    private val mHandler: Handler
    private var mMsgViewScrolledQueued = false

    init {
        mHandler = Handler(HandlerCallback(eventSender))
    }

    /**
     * Post a callback to send a [AccessibilityEvent.TYPE_VIEW_SCROLLED] event.
     * This event is sent at most once every
     * [android.view.ViewConfiguration.getSendRecurringAccessibilityEventsInterval]
     */
    fun postViewScrolledAccessibilityEventCallback() {
        if (mMsgViewScrolledQueued) return
        mMsgViewScrolledQueued = true
        val msg = mHandler.obtainMessage(MSG_VIEW_SCROLLED)
        mHandler.sendMessageDelayed(msg, SEND_RECURRING_ACCESSIBILITY_EVENTS_INTERVAL_MILLIS)
    }

    fun removePostedViewScrolledAccessibilityEventCallback() {
        if (!mMsgViewScrolledQueued) return
        mMsgViewScrolledQueued = false
        mHandler.removeMessages(MSG_VIEW_SCROLLED)
    }

    fun removePostedCallbacks() {
        removePostedViewScrolledAccessibilityEventCallback()
    }

    inner class HandlerCallback(private val mEventSender: View) : Handler.Callback {
        override fun handleMessage(msg: Message): Boolean {
            if (msg.what == MSG_VIEW_SCROLLED) {
                mMsgViewScrolledQueued = false
                mEventSender.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SCROLLED)
            } else {
                throw IllegalStateException(
                    "AccessibilityInjector: unhandled message: " + msg.what
                )
            }
            return true
        }

    }

    companion object {
        // This is copied straight out of android.view.ViewConfiguration.
        private const val SEND_RECURRING_ACCESSIBILITY_EVENTS_INTERVAL_MILLIS: Long = 100
        private const val MSG_VIEW_SCROLLED: Int = 1
    }
}