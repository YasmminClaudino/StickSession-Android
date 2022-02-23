package com.study.ymmc.stickysession.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.study.ymmc.stickysession.data.remote.GetSessionResponse
import com.study.ymmc.stickysession.data.remote.SessionRemoteData
import com.study.ymmc.stickysession.model.Session
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SessionRepository(private val sessionRemoteData: SessionRemoteData) {
    private val sessions: MutableLiveData<List<Session>> = MutableLiveData()
    fun getSession(meetingId: String): LiveData<List<Session>> {
        sessionRemoteData.apiService.getSessions(meetingId).enqueue(object: Callback<List<GetSessionResponse>>{
            override fun onResponse(call: Call<List<GetSessionResponse>>, response: Response<List<GetSessionResponse>>) {
                if (response.isSuccessful) {
                    sessions.value = response.body()?.map { getSessionResponse ->
                        Session(name = getSessionResponse.name,
                            description = getSessionResponse.description,
                            responseNumber = getSessionResponse.answer)
                    }
                }
            }
            override fun onFailure(call: Call<List<GetSessionResponse>>, t: Throwable) {
                t.printStackTrace()
            }
        })
        return sessions
    }
}