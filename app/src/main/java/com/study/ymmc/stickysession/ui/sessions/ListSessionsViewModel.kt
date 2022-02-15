package com.study.ymmc.stickysession.ui.sessions

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.study.ymmc.stickysession.model.Session


class ListSessionsViewModel: ViewModel() {

    val load: LiveData<Boolean>
        get() {
            return isLoad
        }
    val session: LiveData<List<Session>>
        get() {
            return listSession
        }
    private val listSession: MutableLiveData<List<Session>> by lazy {
        MutableLiveData<List<Session>>().also {
        }
    }

    val isLoad: MutableLiveData<Boolean> by lazy {
        MutableLiveData()
    }

    public fun loadData() {
        isLoad.value = true
        Handler().postDelayed(Runnable {
            listSession.postValue(listOf(
                Session("Item", "", 0),
                Session("Item 2", "", 0),
                Session("Item 3", "", 0),
                Session("Item 4", "", 0),
                Session("Item 5", "", 0)
            ))
            isLoad.value = false
        } ,2000L)

    }
}