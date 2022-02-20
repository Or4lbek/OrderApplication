package com.sapar.orderapplication.data.network.provider

interface IUserProvider {

    fun getAuthToken(): String?

    fun saveAuthToken(authToken: String?)

}
