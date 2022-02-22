package com.sapar.orderapplication.data.network.api

import com.sapar.orderapplication.data.network.NetworkManager

class ApiHelper {
    companion object {


        var instance: ApiHelper? = null
            get() {
                if (field == null) {
                    field = ApiHelper()
                    networkManager = NetworkManager.instance
                }
                return field
            }

        private var networkManager: NetworkManager? = null
    }

    var authorizationAPI: AuthorizationApi? = null
        get() {
            if (field == null) {
                field = networkManager?.retrofit?.create(AuthorizationApi::class.java)
            }
            return field
        }

    var marketApi: OrderApi? = null
        get() {
            if (field == null) {
                field = networkManager?.retrofit?.create(OrderApi::class.java)
            }
            return field
        }


    var cartApi: RestaurantApi? = null
        get() {
            if (field == null) {
                field = networkManager?.retrofit?.create(RestaurantApi::class.java)
            }
            return field
        }
}