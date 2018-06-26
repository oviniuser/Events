package br.com.anibal.events.database

import br.com.anibal.events.domain.Arguments.event
import br.com.anibal.events.domain.Event

/**
 * @author user
 */
object DatabaseService {
    fun getFavoriteEvents(): List<Event> {
        val dao = DatabaseManager.getEventDAO()
        return dao.getFavoriteEvents()
    }

    fun getEvents(): List<Event> {
        val dao = DatabaseManager.getEventDAO()
        return dao.getEvents()
    }

    fun setFavorite(event: Event): Boolean {
        val dao = DatabaseManager.getEventDAO()

        event.favorite = !event.favorite

        dao.updateEvent(event.favorite, event.id)
        return event.favorite
    }

    fun isFavorite(event: Event): Boolean {
        val dao = DatabaseManager.getEventDAO()
        return dao.getFavoriteEventById(event.id) != null
    }

    fun isSaved(event: Event): Boolean {
        val dao = DatabaseManager.getEventDAO()
        return dao.getEventById(event.id) != null
    }

    fun saveEvents(events: List<Event>) {
        val dao = DatabaseManager.getEventDAO()

        for (event in events) {
            val insert = isSaved(event)
            if(!insert)
                dao.insertEvent(event)
        }
    }
}