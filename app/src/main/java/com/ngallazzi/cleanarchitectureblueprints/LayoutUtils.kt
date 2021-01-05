package com.ngallazzi.cleanarchitectureblueprints

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View
import androidx.core.view.isVisible

class LayoutUtils {
    companion object {
        fun crossFade(viewToShow: View, viewToHide: View, duration: Int = 500) {
            if (!viewToShow.isVisible) {
                viewToHide.visibility = View.VISIBLE
                viewToShow.fadeIn(duration)
                // Animate the loading viewToShow to 0% opacity. After the animation ends,
                // set its visibility to GONE as an optimization step (it won't
                // participate in layout passes, etc.)
                viewToHide.animate()
                    .alpha(0f)
                    .setDuration(duration.toLong())
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            viewToHide.visibility = View.GONE
                        }
                    })
            }
        }
    }
}

fun View.fadeIn(duration: Int = 500) {
    this.apply {
        // Set the content view to 0% opacity but visible, so that it is visible
        // (but fully transparent) during the animation.
        alpha = 0f
        visibility = View.VISIBLE

        // Animate the content view to 100% opacity, and clear any animation
        // listener set on the view.
        animate()
            .alpha(1f)
            .setDuration(duration.toLong())
            .setListener(null)
    }
}