package br.com.anibal.events.domain

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

/**
 * @author user
 */
@Entity(tableName = "talk")
data class Talk(@PrimaryKey var id: Int = 0,
                @ColumnInfo(name = "event_id")
                var event: Int = 0,
                @ColumnInfo(name = "name")
                var name: String = "",
                @ColumnInfo(name = "category")
                var category: String = "",
                @ColumnInfo(name = "description")
                var desc: String = "",
                @ColumnInfo(name = "max_people")
                var maxPeople: Int = 0,
                @ColumnInfo(name = "date")
                var date: String = "",
                @ColumnInfo(name = "start_time")
                var startTime: String = "",
                @ColumnInfo(name = "finish_time")
                var finishTime: String = "",
                @ColumnInfo(name = "location")
                var location: String = "",
                @ColumnInfo(name = "favorite")
                var favorite: Boolean) : Serializable