package br.com.anibal.events.domain

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

/**
 * @author user
 */
@Entity(tableName = "speaker")
data class Speaker(@PrimaryKey var id: Int = 0,
                   @ColumnInfo(name = "name")
                   var name: String = "",
                   @ColumnInfo(name = "email")
                   var email: String = "",
                   @ColumnInfo(name = "formation")
                   var formation: String = "",
                   @ColumnInfo(name = "bio")
                   var bio: String = "",
                   @ColumnInfo(name = "image")
                   var image: String = "",
                   @ColumnInfo(name = "favorite")
                   var favorite: Boolean) : Serializable