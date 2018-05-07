package br.com.anibal.events.extension

import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.widget.Toast

/**
 * Created by user on 23/03/18.
 */

fun Fragment.toast(message: CharSequence, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(activity, message, length).show()
}

fun Fragment.toast(@StringRes message: Int, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(activity, message, length).show()
}