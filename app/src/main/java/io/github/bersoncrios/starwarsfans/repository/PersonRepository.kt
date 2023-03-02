package io.github.bersoncrios.starwarsfans.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.bersoncrios.starwarsfans.db.PersonDataBase
import io.github.bersoncrios.starwarsfans.models.Persons
import io.github.bersoncrios.starwarsfans.network.SWService

class PersonRepository(
    private val swService: SWService,
    private val personDataBase: PersonDataBase
) {
    private val _items = MutableLiveData<Persons>()

    val items: LiveData<Persons>
        get() = _items
    suspend fun getPersons() {
        val res = swService.getPeoples()
        if (res.body() != null) {
            personDataBase.personDao().addPerson(res.body()!!.results)
            _items.postValue(res.body())
        }
    }
}