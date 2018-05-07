package br.com.anibal.events.domain

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by user on 21/03/18.
 */

interface EventService {

    @GET("events")
    fun getEvents(): Call<List<Event>>

    @GET("talks/{id}")
    fun getTalk(@Path("id") id: Int): Call<Talk>

    @GET("speakers")
    fun getSpeakers(): Call<List<Speaker>>
}