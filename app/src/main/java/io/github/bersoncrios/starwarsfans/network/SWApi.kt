package io.github.bersoncrios.starwarsfans.network

import io.github.bersoncrios.starwarsfans.models.Persons
import retrofit2.Response
import retrofit2.http.GET

interface SWApi {

    @GET("people/")
    suspend fun getPeoples() : Response<Persons>
}