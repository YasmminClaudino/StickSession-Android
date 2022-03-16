package com.study.ymmc.stickysession.service

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log
import com.study.ymmc.stickysession.data.remote.GetSessionResponse
import com.study.ymmc.stickysession.data.remote.SessionLocalData
import com.study.ymmc.stickysession.data.remote.SessionRemoteData
import com.study.ymmc.stickysession.injection.ServiceLocator
import com.study.ymmc.stickysession.model.Session
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteRequestJobService: JobService() {

    private lateinit var sessionRemoteData: SessionRemoteData
    private lateinit var localData: SessionLocalData

    override fun onCreate() {
        sessionRemoteData = SessionRemoteData()
        localData = ServiceLocator.sessionLocalData
    }
    override fun onStartJob(parameters: JobParameters): Boolean {
        Log.d("Yaya", "onStartJob")
        val meetingId: String = parameters.extras.get("meetingId") as String
        sessionRemoteData.apiService.getSessions(meetingId).enqueue(object:
            Callback<List<GetSessionResponse>> {
            override fun onResponse(call: Call<List<GetSessionResponse>>, response: Response<List<GetSessionResponse>>) {
                Log.d("Yaya", "getSessionOnResponse")
                if (response.isSuccessful) {
                    response.body()?.map { getSessionResponse ->
                        Session(name = getSessionResponse.name,
                            description = getSessionResponse.description,
                            responseNumber = getSessionResponse.answer)
                    }?.let { localData.saveSession(it) }
                }
                jobFinished(parameters, false)
            }
            override fun onFailure(call: Call<List<GetSessionResponse>>, t: Throwable) {
                t.printStackTrace()
                jobFinished(parameters, false)
            }
        })
        return true
    }

    override fun onStopJob(p0: JobParameters?): Boolean {
        return false
    }
}