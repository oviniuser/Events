package br.com.anibal.events.web

import br.com.anibal.events.domain.Setting
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val retrofit = Retrofit.Builder()
                .baseUrl(Setting.server)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    fun eventService(): EventService = retrofit.create(EventService::class.java)
}