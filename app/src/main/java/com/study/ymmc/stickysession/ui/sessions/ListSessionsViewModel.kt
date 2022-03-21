package com.study.ymmc.stickysession.ui.sessions

import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import com.study.ymmc.stickysession.data.SessionRepository
import com.study.ymmc.stickysession.data.remote.SessionSchedulerRemoteData
import com.study.ymmc.stickysession.injection.ServiceLocator
import com.study.ymmc.stickysession.model.Session


class ListSessionsViewModel(private val sessionRepository: SessionRepository): ViewModel() {

    private val isLoad: MutableLiveData<Boolean> by lazy {
        MutableLiveData()
    }
    private val mutableSession: MutableLiveData<List<Session>> = MutableLiveData()
    val load: LiveData<Boolean>

        get() {
            return isLoad
        }
    val session: LiveData<List<Session>>
        get() {
            return mutableSession
        }

    fun loadData(context: LifecycleOwner) {
        isLoad.value = true
        sessionRepository.getSession("7e25a2a1-c29c-41ed-886e-21c0081a1197").observe(context){ sessions ->
            Log.d("Yaya", "loadData getSession")
            mutableSession.value = sessions
            isLoad.value = false
        }

    }

}

class ListSessionFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListSessionsViewModel::class.java)) {
            return ListSessionsViewModel(SessionRepository(SessionSchedulerRemoteData(context), ServiceLocator.sessionLocalData)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}