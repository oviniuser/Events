package br.com.anibal.events.database

import android.arch.persistence.room.Room
import br.com.anibal.events.EventApplication

object DatabaseManager {
    private var database: Database
    init {
        val appContext = EventApplication.getInstance().applicationContext
        database = Room.databaseBuilder(appContext,
                Database::class.java,
                "events.db")
                .build()
    }

    fun getEventDAO(): EventDAO {
        return database.eventDAO()
    }
}