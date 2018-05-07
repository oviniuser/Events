package br.com.anibal.events.domain

import java.io.Serializable

/**
 * Created by user on 06/05/18.
 */

data class Talk(var id: Int = 0,
                var event: String = "",
                var speakers: List<Int>,
                var name: String = "",
                var category: String = "",
                var desc: String = "",
                var maxPeople: Int = 0,
                var date: String = "",
                var startTime: String = "",
                var finishTime: String = "",
                var location: String = ""): Serializable