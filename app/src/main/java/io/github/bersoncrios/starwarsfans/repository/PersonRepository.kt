package io.github.bersoncrios.starwarsfans.repository

import io.github.bersoncrios.starwarsfans.models.Persons
import io.github.bersoncrios.starwarsfans.network.SWService
import retrofit2.Response

class PersonRepository(
    private val swService: SWService
) {
    suspend fun getPeoples(): Response<Persons> = swService.api.getPeoples()

}