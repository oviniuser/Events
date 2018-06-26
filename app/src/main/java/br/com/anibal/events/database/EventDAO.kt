package br.com.anibal.events.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import br.com.anibal.events.domain.Event

@Dao
interface EventDAO {
    @Query("SELECT * FROM event where id = :eventId")
    fun getEventById(eventId: Int): Event?

    @Query("SELECT * FROM event")
    fun getEvents(): List<Event>

    @Insert(onConflict = REPLACE)
    fun insertEvent(event: Event)

    @Delete
    fun deleteEvent(event: Event)

    @Query("DELETE FROM event")
    fun deleteEvents()
}