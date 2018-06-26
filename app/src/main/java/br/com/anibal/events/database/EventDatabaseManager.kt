package br.com.anibal.events.database

import android.arch.persistence.room.Room
import br.com.anibal.events.EventApplication

object EventDatabaseManager {
    private var database: EventDatabase

    init {
        val appContext = EventApplication.getInstance().applicationContext
        database = Room.databaseBuilder(appContext,
                EventDatabase::class.java,
                "events.db")
                .build()
    }

    fun getEventDAO(): EventDAO {
        return database.eventDAO()
    }
}