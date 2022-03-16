package com.study.ymmc.stickysession.injection

import com.study.ymmc.stickysession.data.remote.SessionLocalData

object ServiceLocator {

    val sessionLocalData: SessionLocalData by lazy {
        SessionLocalData()
    }

}