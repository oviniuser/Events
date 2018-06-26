package br.com.anibal.events.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import br.com.anibal.events.domain.Event

@Dao
interface EventDAO {
    @Query("select * from event where id = :eventId and favorite = 1")
    fun getFavoriteEventById(eventId: Int): Event?

    @Query("select * from event where favorite = 1")
    fun getFavoriteEvents(): List<Event>

    @Query("select * from event")
    fun getEvents(): List<Event>

    @Query("select * from event where id = :eventId")
    fun getEventById(eventId: Int): Event?

    @Insert(onConflict = REPLACE)
    fun insertEvent(event: Event)

    @Query("update event set favorite = :favorite where id = :eventId")
    fun updateEvent(favorite: Boolean, eventId: Int)

    @Delete
    fun deleteEvent(event: Event)

    @Query("delete from event")
    fun deleteEvents()
}