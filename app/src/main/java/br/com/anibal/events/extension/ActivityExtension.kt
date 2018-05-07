package br.com.anibal.events.extension

import android.app.Activity
import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Toast

/**
 * Created by user on 19/03/18.
 */

fun AppCompatActivity.onClick(@IdRes viewId: Int, onClick: (viewIn: android.view.View?) -> Unit) {
    val view = findViewById<View>(viewId)
    view.setOnClickListener { onClick(it) }
}

fun AppCompatActivity.setupToolBar(@IdRes id: Int, title: String? = null, upNavigation: Boolean = false): ActionBar {
    val toolbar = findViewById<Toolbar>(id)
    setSupportActionBar(toolbar)

    if (title != null) {
        supportActionBar?.title = title
    }

    supportActionBar?.setDisplayHomeAsUpEnabled(upNavigation)
    return supportActionBar!!
}

fun AppCompatActivity.addFragment(@IdRes layoutId: Int, fragment: Fragment) {
    fragment.arguments = intent.extras
    val fragmentTransaction = supportFragmentManager.beginTransaction()
    fragmentTransaction.add(layoutId, fragment)
    fragmentTransaction.commit()
}