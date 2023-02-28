package io.github.bersoncrios.starwarsfans.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SWService {
     val api : SWApi = Retrofit.Builder()
        .baseUrl("https://swapi.dev/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(SWApi::class.java)
}