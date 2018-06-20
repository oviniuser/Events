package br.com.anibal.events.web

import br.com.anibal.events.domain.Event
import br.com.anibal.events.domain.Speaker
import br.com.anibal.events.domain.Talk
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by user on 21/03/18.
 */

interface EventService {

    @GET("events")
    fun getEvents(): Call<List<Event>>

    @GET("now-events")
    fun getNowEvents(): Call<List<Event>>

    @GET("next-events")
    fun getNextEvents(): Call<List<Event>>

    @GET("events/{id}/talks")
    fun getTalks(@Path("id") id: Int): Call<List<Talk>>

    @GET("speakers/{id}/talks")
    fun getTalksSpeaker(@Path("id") id: Int): Call<List<Talk>>

    @GET("talks/{id}/speakers")
    fun getSpeakers(@Path("id") id: Int): Call<List<Speaker>>
}