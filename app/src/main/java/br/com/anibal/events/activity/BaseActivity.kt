package br.com.anibal.events.activity

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.app.AppCompatActivity

/**
 * Created by user on 19/03/18.
 */

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {
    protected val context: Context get() = this
}