package com.study.ymmc.stickysession.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface StickSessionApi {
    @GET("/session")
    fun getSessions(@Query("meetingId") meetingId: String)
}