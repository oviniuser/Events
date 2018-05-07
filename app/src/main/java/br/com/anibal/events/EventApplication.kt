package br.com.anibal.events

import android.app.Application
import android.util.Log

/**
 * Created by user on 19/03/18.
 */

class EventApplication : Application() {

    private val TAG = "EventApplication"

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        private var appInstance: EventApplication? = null

        fun getInstance(): EventApplication {
            if(appInstance == null) {
                throw IllegalArgumentException("Erro de configuração em AndroidManifest.xml")
            }
            return appInstance!!
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        Log.d(TAG, "EventApplication.onTerminate()")
    }
}