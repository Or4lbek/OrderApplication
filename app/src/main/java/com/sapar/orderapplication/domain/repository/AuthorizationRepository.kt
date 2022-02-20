package com.sapar.orderapplication.domain.repository

interface AuthorizationRepository {

    // callOnLoginButtonClick
    // callOnUnauthorizedCreateOrderAttempt
    fun login(email: String, password: String)

    // callOnSignUpButtonClick
    // callOnUnauthorizedCreateOrderAttempt
    fun signUp(email: String, password: String)
}