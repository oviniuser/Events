package br.com.anibal.events.domain

import android.os.Bundle

object Arguments {

    private val bundle = Bundle()
    private const val key_event = "event"
    private const val key_talk = "talk"
    private const val key_speaker = "speaker"
    private const val key_type = "type"

    private fun putEvent(event: Event) {
        bundle.remove(key_event)
        bundle.putSerializable(key_event, event)
    }

    private fun findEvent(): Event {
        return bundle.getSerializable(key_event) as Event
    }

    private fun putTalk(talk: Talk) {
        bundle.remove(key_talk)
        bundle.putSerializable(key_talk, talk)
    }

    private fun findTalk(): Talk {
        return bundle.getSerializable(key_talk) as Talk
    }

    private fun putSpeaker(speaker: Speaker) {
        bundle.remove(key_speaker)
        bundle.putSerializable(key_speaker, speaker)
    }

    private fun findSpeaker(): Speaker {
        return bundle.getSerializable(key_speaker) as Speaker
    }

    private fun putType(menuItemString: MenuItemString) {
        bundle.remove(key_type)
        bundle.putSerializable(key_type, menuItemString)
    }

    private fun findType(): MenuItemString {
        return bundle.getSerializable(key_type) as MenuItemString
    }

    fun putInt(key: String, int: Int) {
        bundle.remove(key)
        bundle.putInt(key, int)
    }

    fun findInt(key: String): Int {
        return bundle.getInt(key)
    }

    var event: Event
        get() = findEvent()
        set(value) = putEvent(value)

    var talk: Talk
        get() = findTalk()
        set(value) = putTalk(value)

    var speaker: Speaker
        get() = findSpeaker()
        set(value) = putSpeaker(value)

    var type: MenuItemString
        get() = findType()
        set(value) = putType(value)
}