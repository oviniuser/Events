package br.com.anibal.events.domain

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

/**
 * Created by user on 21/03/18.
 */
@Entity(tableName="event")
data class Event(@PrimaryKey var id: Int = 0,
                 @ColumnInfo(name="name")
                 var name: String = "",
                 @ColumnInfo(name="description")
                 var desc: String = "",
                 @ColumnInfo(name="image")
                 var image: String = "",
                 @ColumnInfo(name="start_date")
                 var startDate: String = "",
                 @ColumnInfo(name="finish_date")
                 var finishDate: String = "",
                 @ColumnInfo(name="latitude")
                 var latitude: String = "",
                 @ColumnInfo(name="longitude")
                 var longitude: String = ""): Serializable