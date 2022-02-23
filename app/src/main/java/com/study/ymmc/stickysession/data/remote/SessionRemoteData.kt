package com.study.ymmc.stickysession.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SessionRemoteData {
     var apiService: StickSessionApi
        private set

    constructor() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://study-web-app.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiService = retrofit.create(StickSessionApi::class.java)
    }

}