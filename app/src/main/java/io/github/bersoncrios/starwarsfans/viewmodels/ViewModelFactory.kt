package io.github.bersoncrios.starwarsfans.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.bersoncrios.starwarsfans.repository.PersonRepository

class ViewModelFactory(private val repository: PersonRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PersonViewModel(repository) as T
    }
}