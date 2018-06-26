package br.com.anibal.events.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import br.com.anibal.events.domain.Talk

@Dao
interface TalkDAO {
    @Query("select * from talk where id = :talkId")
    fun getTalkById(talkId: Int): Talk?

    @Query("select * from talk where event_id = :eventId")
    fun getEventTalks(eventId: Int): List<Talk>

    @Insert(onConflict = REPLACE)
    fun insertTalk(talk: Talk)
}