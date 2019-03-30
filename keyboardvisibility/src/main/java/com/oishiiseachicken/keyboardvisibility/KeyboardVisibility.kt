package com.oishiiseachicken.keyboardvisibility

import android.app.Activity
import android.graphics.Rect

interface KeyboardVisibility {

    fun <T : Activity> T.setOnVisibleChangeListener(listener: VisibleChangeListener) {
        val visibleFrame = Rect()
        var prevHeight = -1

        window.decorView.viewTreeObserver.addOnGlobalLayoutListener {
            window.decorView.getWindowVisibleDisplayFrame(visibleFrame)
            val height = visibleFrame.height()
            if (prevHeight < 0) {
                prevHeight = height
                return@addOnGlobalLayoutListener
            }

            if (height < prevHeight) {
                listener.onShown()
            } else if (height > prevHeight) {
                listener.onHidden()
            }

            prevHeight = height
        }
    }

    interface VisibleChangeListener {
        fun onShown()
        fun onHidden()
    }
}
