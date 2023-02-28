package io.github.bersoncrios.starwarsfans.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.bersoncrios.starwarsfans.models.Persons
import io.github.bersoncrios.starwarsfans.network.SWService
import io.github.bersoncrios.starwarsfans.repository.PersonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PersonViewModel : ViewModel() {
    private val service = SWService()
    private val repository = PersonRepository(service)
    private val _items = MutableLiveData<Persons>()

    val items: LiveData<Persons>
        get() = _items

    fun fetchPersons() {
        viewModelScope.launch(Dispatchers.IO) {
            val res = repository.getPeoples()

            if (res.isSuccessful) {
                withContext(Dispatchers.Main) {
                    _items.value = res.body()
                }
            }
        }
    }
}