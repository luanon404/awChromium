package org.chromium.blink_public.common

import androidx.annotation.IntDef

@IntDef(
    ContextMenuDataMediaType.NONE,
    ContextMenuDataMediaType.IMAGE,
    ContextMenuDataMediaType.VIDEO,
    ContextMenuDataMediaType.AUDIO,
    ContextMenuDataMediaType.CANVAS,
    ContextMenuDataMediaType.FILE,
    ContextMenuDataMediaType.PLUGIN
)
@Retention(AnnotationRetention.SOURCE)
annotation class ContextMenuDataMediaType {
    companion object {
        /**
         * No special node is in context.
         */
        const val NONE = 0

        /**
         * An image node is selected.
         */
        const val IMAGE = 1

        /**
         * A video node is selected.
         */
        const val VIDEO = 2

        /**
         * An audio node is selected.
         */
        const val AUDIO = 3

        /**
         * A canvas node is selected.
         */
        const val CANVAS = 4

        /**
         * A file node is selected.
         */
        const val FILE = 5

        /**
         * A plugin node is selected.
         */
        const val PLUGIN = 6
    }
}
