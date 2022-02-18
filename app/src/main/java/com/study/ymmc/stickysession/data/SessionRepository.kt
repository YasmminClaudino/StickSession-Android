package com.study.ymmc.stickysession.data

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.study.ymmc.stickysession.data.remote.SessionRemoteData
import com.study.ymmc.stickysession.model.Session

class SessionRepository(private val sessionRemoteData: SessionRemoteData) {
    private val sessions: MutableLiveData<List<Session>> = MutableLiveData()
    fun getSession(): LiveData<List<Session>> {
        Handler().postDelayed(Runnable {
            sessions.postValue(listOf(
                Session("Item", "", 0),
                Session("Item 2", "", 0),
                Session("Item 3", "", 0),
                Session("Item 4", "", 0),
                Session("Item 5", "", 0)
            ))
        } ,2000L)

        return sessions
    }
}