package br.com.anibal.events.domain

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.1.6:8000")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
//    vieirateam.pythonanywhere.com

    fun eventService(): EventService = retrofit.create(EventService::class.java)
}