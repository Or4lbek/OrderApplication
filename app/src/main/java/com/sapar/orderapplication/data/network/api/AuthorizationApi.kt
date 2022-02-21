package com.sapar.orderapplication.data.network.api

import com.sapar.orderapplication.data.network.dto.AuthorizationToken
import com.sapar.orderapplication.data.network.request.LoginRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthorizationApi {
    @POST
    suspend fun login(
        @Body loginRequest: LoginRequest
    ) : Response<AuthorizationToken>
}