package com.study.ymmc.stickysession.ui.sessions

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.study.ymmc.stickysession.R
import com.study.ymmc.stickysession.model.Session


class ListSessionsActivity : AppCompatActivity() {
    private lateinit var adapter: ListSessionsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_sessions_acitivity)
        val listSession = findViewById<RecyclerView>(R.id.listSession)
        adapter = ListSessionsAdapter()
        listSession.adapter = adapter
        listSession.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
            false)
        val model: ListSessionsViewModel = ViewModelProvider(this)[ListSessionsViewModel::class.java]
        model.session.observe(this) { sessions ->
            adapter.updateList(sessions)
        }
    }

    override fun onResume() {
        super.onResume()
        val model: ListSessionsViewModel = ViewModelProvider(this)[ListSessionsViewModel::class.java]
        model.loadData()
    }



}