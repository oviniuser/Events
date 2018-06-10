package br.com.anibal.events.domain

import android.content.SharedPreferences
import br.com.anibal.events.EventApplication

object Setting {
    private const val key = "key"
    private const val PREF_ID = "events"

    private fun prefs(): SharedPreferences {
        val context = EventApplication.getInstance().applicationContext
        return context.getSharedPreferences(PREF_ID, 0)
    }

    fun setUrlServer(value: String) {
        val pref = prefs()
        val editor = pref.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getUrlServer(): String {
        val pref = prefs()
        return pref.getString(this.key, "")
    }

    var server
        get() = getUrlServer()
        set(value) = setUrlServer(value)
}