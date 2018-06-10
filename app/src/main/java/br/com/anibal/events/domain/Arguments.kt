package br.com.anibal.events.domain

import android.os.Bundle

object Arguments {

    private val bundle = Bundle()
    private const val key = "event"

    private fun putEvent(event: Event) {
        bundle.remove(key)
        bundle.putSerializable(key, event)
    }

    private fun findEvent(): Event {
        return bundle.getSerializable(key) as Event
    }

    var event: Event
        get() = findEvent()
        set(value) = putEvent(value)
}