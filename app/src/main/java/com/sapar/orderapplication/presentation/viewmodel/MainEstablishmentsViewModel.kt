package com.sapar.orderapplication.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sapar.orderapplication.domain.entities.RestaurantDetails
import com.sapar.orderapplication.domain.entities.RestaurantInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainEstablishmentsViewModel : ViewModel() {

    private var liveDataEstablishmentsMutable: MutableLiveData<List<RestaurantDetails>> = MutableLiveData()
    val liveDataEstablishments: LiveData<List<RestaurantDetails>> = liveDataEstablishmentsMutable

    fun loadEstablishmentsApi() {
        viewModelScope.launch(Dispatchers.IO) {

        }
    }
}