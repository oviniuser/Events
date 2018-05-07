package br.com.anibal.events.domain

import java.io.Serializable

/**
 * Created by user on 06/05/18.
 */

data class Speaker(var id: Int = 0,
                   var name: String = "",
                   var email: String = "",
                   var formation: String = "",
                   var bio: String = "",
                   var image: String = "",
                   var speakers: List<Int>): Serializable