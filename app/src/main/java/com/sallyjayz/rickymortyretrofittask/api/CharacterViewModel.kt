package com.sallyjayz.rickymortyretrofittask.api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CharacterViewModel:ViewModel() {

    private val _properties = MutableLiveData<List<RickyMortyResult>>()

    // The external LiveData interface to the property is immutable, so only this class can modify
    val properties: LiveData<List<RickyMortyResult>>
        get() = _properties

    init {
        getRickyMorty()
    }

    private fun getRickyMorty() {
        viewModelScope.launch {
            try {
                _properties.value = CharacterApi.retrofitService.getProperties().results
                Log.d("CharacterViewModel", "getRickyMorty: ${_properties.value}")
            } catch (e: Exception) {
//                _properties.value = ArrayList()
                Log.e("CharacterViewModel", e.message.toString())
            }
        }
    }

}