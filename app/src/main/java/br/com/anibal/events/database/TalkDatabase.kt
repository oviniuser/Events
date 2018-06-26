package br.com.anibal.events.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import br.com.anibal.events.domain.Talk

@Database(entities = [(Talk::class)], version = 1)
abstract class TalkDatabase : RoomDatabase() {
    abstract fun talkDAO(): TalkDAO
}