package io.github.bersoncrios.starwarsfans.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
     fun getInstance() : Retrofit {
         return Retrofit.Builder()
             .baseUrl("https://swapi.dev/api/")
             .addConverterFactory(GsonConverterFactory.create())
             .build()
     }
}