package com.sapar.orderapplication.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sapar.orderapplication.data.network.RetroInstance
import com.sapar.orderapplication.data.network.RetroServiceInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyOrdersViewModel : ViewModel() {

    private val liveDataMyOrdersMutable: MutableLiveData<List<Order>> =
        MutableLiveData()
    val liveDataMyOrders: LiveData<List<Order>> = liveDataMyOrdersMutable

    fun loadMyOrdersApi() {
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance = RetroInstance.getRetrofitInstance()
            val retroService = retroInstance.create(RetroServiceInterface::class.java)
            val call = withContext(Dispatchers.IO) {
                retroService.getMyOrders()
            }
            liveDataMyOrdersMutable.postValue(call)
        }
    }
}