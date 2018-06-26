package br.com.anibal.events.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import br.com.anibal.events.domain.Event

@Database(entities = [(Event::class)], version = 1)
abstract class EventDatabase: RoomDatabase() {
    abstract fun eventDAO(): EventDAO
}