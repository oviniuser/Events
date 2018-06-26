package br.com.anibal.events.domain

import br.com.anibal.events.database.DatabaseManager

object FavoriteService {
    fun getEvents(): List<Event> {
        val dao = DatabaseManager.getEventDAO()
        return dao.getEvents()
    }

    fun isFavorite(event: Event): Boolean {
        val dao = DatabaseManager.getEventDAO()
        return dao.getEventById(event.id) != null
    }

    fun setFavorite(event: Event): Boolean {
        val dao = DatabaseManager.getEventDAO()
        val favorite = isFavorite(event)

        if(favorite) {
            dao.deleteEvent(event)
            return false
        }
        dao.insertEvent(event)
        return true
    }
}