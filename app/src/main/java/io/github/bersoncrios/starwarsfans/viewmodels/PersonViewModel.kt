package io.github.bersoncrios.starwarsfans.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.bersoncrios.starwarsfans.models.Persons
import io.github.bersoncrios.starwarsfans.repository.PersonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonViewModel(private val repository: PersonRepository) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getPersons()
        }
    }

    val persons : LiveData<Persons>
        get() = repository.items
}