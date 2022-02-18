package com.study.ymmc.stickysession.data.remote

import retrofit2.Retrofit

class SessionRemoteData {
    private val apiService: StickSessionApi

    constructor() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://study-web-app.herokuapp.com")
            .build()
        apiService = retrofit.create(StickSessionApi::class.java)
    }

}