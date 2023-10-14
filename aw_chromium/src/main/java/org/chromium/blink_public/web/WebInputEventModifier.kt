package org.chromium.blink_public.web

import androidx.annotation.IntDef

@IntDef(
    WebInputEventModifier.SHIFT_KEY,
    WebInputEventModifier.CONTROL_KEY,
    WebInputEventModifier.ALT_KEY,
    WebInputEventModifier.META_KEY,
    WebInputEventModifier.IS_KEY_PAD,
    WebInputEventModifier.IS_AUTO_REPEAT,
    WebInputEventModifier.LEFT_BUTTON_DOWN,
    WebInputEventModifier.MIDDLE_BUTTON_DOWN,
    WebInputEventModifier.RIGHT_BUTTON_DOWN,
    WebInputEventModifier.CAPS_LOCK_ON,
    WebInputEventModifier.NUM_LOCK_ON,
    WebInputEventModifier.IS_LEFT,
    WebInputEventModifier.IS_RIGHT,
    WebInputEventModifier.IS_TOUCH_ACCESSIBILITY,
    WebInputEventModifier.IS_COMPOSING,
    WebInputEventModifier.ALT_GR_KEY,
    WebInputEventModifier.FN_KEY,
    WebInputEventModifier.SYMBOL_KEY,
    WebInputEventModifier.SCROLL_LOCK_ON,
    WebInputEventModifier.IS_COMPATIBILITY_EVENT_FOR_TOUCH,
    WebInputEventModifier.BACK_BUTTON_DOWN,
    WebInputEventModifier.FORWARD_BUTTON_DOWN,
    WebInputEventModifier.RELATIVE_MOTION_EVENT,
    WebInputEventModifier.FROM_DEBUGGER,
    WebInputEventModifier.TARGET_FRAME_MOVED_RECENTLY,
    WebInputEventModifier.SCROLLBAR_MANIPULATION_HANDLED_ON_COMPOSITOR_THREAD,
    WebInputEventModifier.KEY_MODIFIERS,
    WebInputEventModifier.NO_MODIFIERS
)
@Retention(
    AnnotationRetention.SOURCE
)
annotation class WebInputEventModifier {
    companion object {
        const val SHIFT_KEY = 1 shl 0
        const val CONTROL_KEY = 1 shl 1
        const val ALT_KEY = 1 shl 2
        const val META_KEY = 1 shl 3

        const val IS_KEY_PAD = 1 shl 4
        const val IS_AUTO_REPEAT = 1 shl 5

        const val LEFT_BUTTON_DOWN = 1 shl 6
        const val MIDDLE_BUTTON_DOWN = 1 shl 7
        const val RIGHT_BUTTON_DOWN = 1 shl 8

        const val CAPS_LOCK_ON = 1 shl 9
        const val NUM_LOCK_ON = 1 shl 10
        const val IS_LEFT = 1 shl 11
        const val IS_RIGHT = 1 shl 12

        const val IS_TOUCH_ACCESSIBILITY = 1 shl 13
        const val IS_COMPOSING = 1 shl 14
        const val ALT_GR_KEY = 1 shl 15
        const val FN_KEY = 1 shl 16
        const val SYMBOL_KEY = 1 shl 17
        const val SCROLL_LOCK_ON = 1 shl 18

        const val IS_COMPATIBILITY_EVENT_FOR_TOUCH = 1 shl 19
        const val BACK_BUTTON_DOWN = 1 shl 20
        const val FORWARD_BUTTON_DOWN = 1 shl 21

        const val RELATIVE_MOTION_EVENT = 1 shl 22

        const val FROM_DEBUGGER = 1 shl 23

        const val TARGET_FRAME_MOVED_RECENTLY = 1 shl 24

        const val SCROLLBAR_MANIPULATION_HANDLED_ON_COMPOSITOR_THREAD = 1 shl 25

        const val KEY_MODIFIERS =
            SYMBOL_KEY or FN_KEY or ALT_GR_KEY or META_KEY or ALT_KEY or CONTROL_KEY or SHIFT_KEY
        const val NO_MODIFIERS = 0
    }
}