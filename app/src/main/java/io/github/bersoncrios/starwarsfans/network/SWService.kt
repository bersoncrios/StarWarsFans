package io.github.bersoncrios.starwarsfans.network

import io.github.bersoncrios.starwarsfans.models.Persons
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SWService {
    private val api : SWApi = Retrofit.Builder()
        .baseUrl("https://swapi.dev/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(SWApi::class.java)

    suspend fun getPeoples(): Response<Persons> = api.getPeoples()
}