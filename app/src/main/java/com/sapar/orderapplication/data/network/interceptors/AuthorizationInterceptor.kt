package com.sapar.orderapplication.data.network.interceptors

import com.sapar.orderapplication.data.network.provider.UserProvider
import okhttp3.Interceptor
import okhttp3.Response
import kotlin.jvm.Throws

class AuthorizationInterceptor(private val userProvider: UserProvider) : Interceptor {

    companion object {
        private const val HEADER_PREFIX_AUTH = "Bearer "
        private const val HEADER_AUTH = "Authorization"
    }

    @Throws(Exception::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var token = ""
        if (userProvider.getAuthToken() != null) {
            token = HEADER_PREFIX_AUTH + userProvider.getAuthToken()
        }
        val request = chain.request().newBuilder()
            .addHeader(HEADER_AUTH, token)
            .build()
        return chain.proceed(request)
    }
}