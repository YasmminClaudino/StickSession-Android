package com.study.ymmc.stickysession.data.remote

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.os.PersistableBundle
import com.study.ymmc.stickysession.service.RemoteRequestJobService


class SessionSchedulerRemoteData(private val context: Context) {
    fun getSessions(meetingId: String) {
        val jobService = ComponentName(context, RemoteRequestJobService::class.java)
        val builder = JobInfo.Builder(3, jobService)
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)

        val jobServiceExtras = PersistableBundle()
        jobServiceExtras.putString("meetingId", meetingId)
        builder.setExtras(jobServiceExtras)

        var jobScheduler: JobScheduler = context.getSystemService(JobScheduler::class.java)
        jobScheduler.schedule(builder.build())


    }
}