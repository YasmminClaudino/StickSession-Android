package com.study.ymmc.stickysession.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.study.ymmc.stickysession.data.remote.SessionLocalData
import com.study.ymmc.stickysession.data.remote.SessionRemoteData
import com.study.ymmc.stickysession.data.remote.SessionSchedulerRemoteData
import com.study.ymmc.stickysession.model.Session

class SessionRepository(
    private val sessionSchedulerRemoteData: SessionSchedulerRemoteData,
    private val sessionLocalData: SessionLocalData
) {

    fun getSession(meetingId: String): LiveData<List<Session>> {
        sessionSchedulerRemoteData.getSessions(meetingId)
        return sessionLocalData.getSession()
    }
}