package io.github.amalhanaja.yas

import android.support.design.widget.Snackbar

/**
 * Created by doy on 11/12/17.
 * Email : amalhanaja@gmail.com
 * Created On : 11/12/17.
 */
object Duration {
    val INDEFINED = Snackbar.LENGTH_INDEFINITE
    val SHORT = Snackbar.LENGTH_SHORT
    val LONG = Snackbar.LENGTH_LONG
    val CUSTOM: (Int) -> Int = { it }
}