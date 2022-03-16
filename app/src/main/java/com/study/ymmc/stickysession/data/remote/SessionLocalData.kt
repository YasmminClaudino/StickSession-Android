package com.study.ymmc.stickysession.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.study.ymmc.stickysession.model.Session


typealias SessionList = List<Session>
class SessionLocalData {

    private val sessions: MutableLiveData<SessionList> = MutableLiveData()

    fun saveSession(listSession: SessionList){
        sessions.postValue(listSession)
    }

    fun getSession(): LiveData<SessionList> = sessions
}