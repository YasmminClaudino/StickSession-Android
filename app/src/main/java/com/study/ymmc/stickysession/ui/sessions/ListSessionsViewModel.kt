package com.study.ymmc.stickysession.ui.sessions

import android.content.Context
import androidx.lifecycle.*
import com.study.ymmc.stickysession.data.SessionRepository
import com.study.ymmc.stickysession.data.remote.SessionRemoteData
import com.study.ymmc.stickysession.model.Session


class ListSessionsViewModel(private val sessionRepository: SessionRepository): ViewModel() {

    val mutableSession: MutableLiveData<List<Session>> = MutableLiveData()
    val load: LiveData<Boolean>

        get() {
            return isLoad
        }
    val session: LiveData<List<Session>>
        get() {
            return mutableSession
        }

    val isLoad: MutableLiveData<Boolean> by lazy {
        MutableLiveData()
    }

    fun loadData(context: LifecycleOwner) {
        isLoad.value = true
        sessionRepository.getSession("aa1107dc-0d30-40d8-97fd-31b2676df533").observe(context){ sessions ->
            mutableSession.value = sessions
            isLoad.value = false
        }

    }

}

class ListSessionFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListSessionsViewModel::class.java)) {
            return ListSessionsViewModel(SessionRepository(SessionRemoteData())) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}