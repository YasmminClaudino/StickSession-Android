package com.study.ymmc.stickysession.ui.sessions

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
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
        val load = findViewById<ProgressBar>(R.id.progressBar)
        adapter = ListSessionsAdapter()
        listSession.adapter = adapter
        listSession.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
            false)
        val model = ViewModelProvider(this, ListSessionFactory(this)).get(ListSessionsViewModel::class.java)
        model.session.observe(this) { sessions ->
            adapter.updateList(sessions)
        }
        model.load.observe(this) { isLoad ->
            load.visibility = if (isLoad) View.VISIBLE else View.INVISIBLE
        }
    }

    override fun onResume() {
        super.onResume()
        val model: ListSessionsViewModel = ViewModelProvider(this)[ListSessionsViewModel::class.java]
        model.loadData(this)
    }



}