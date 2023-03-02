package io.github.bersoncrios.starwarsfans

import android.app.Application
import io.github.bersoncrios.starwarsfans.db.PersonDataBase
import io.github.bersoncrios.starwarsfans.network.RetrofitHelper
import io.github.bersoncrios.starwarsfans.network.SWService
import io.github.bersoncrios.starwarsfans.repository.PersonRepository

class Application : Application() {

    lateinit var personRepository: PersonRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val swService = RetrofitHelper.getInstance().create(SWService::class.java)
        val database = PersonDataBase.getDataBase(applicationContext)
        personRepository = PersonRepository(swService, database)
    }
}