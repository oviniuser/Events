package br.com.anibal.events.domain

import java.io.Serializable

/**
 * Created by user on 21/03/18.
 */

data class Event(var id: Int = 0,
                 var name: String = "",
                 var desc: String = "",
                 var image: String = "",
                 var startDate: String = "",
                 var finishDate: String = "",
                 var latitude: String = "",
                 var longitude: String = "",
                 var talks: List<Int>): Serializable