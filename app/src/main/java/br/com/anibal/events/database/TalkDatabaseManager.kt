package br.com.anibal.events.database

import android.arch.persistence.room.Room
import br.com.anibal.events.EventApplication

object TalkDatabaseManager {
    private var database: TalkDatabase

    init {
        val appContext = EventApplication.getInstance().applicationContext
        database = Room.databaseBuilder(appContext,
                TalkDatabase::class.java,
                "talk.db")
                .build()
    }

    fun getTalkDAO(): TalkDAO {
        return database.talkDAO()
    }
}