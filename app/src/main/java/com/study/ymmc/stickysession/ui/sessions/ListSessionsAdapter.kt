package com.study.ymmc.stickysession.ui.sessions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.study.ymmc.stickysession.R
import com.study.ymmc.stickysession.model.Session

class ListSessionsAdapter: RecyclerView.Adapter<SessionItemView>() {
    private var list: List<Session> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionItemView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_session_view, parent, false)
        return SessionItemView(view)
    }

    override fun onBindViewHolder(holder: SessionItemView, position: Int) {
        holder.updateData(list.get(position))
    }

    override fun getItemCount(): Int {
       return list.size
    }

    fun updateList(list: List<Session>){
        this.list = list
        notifyDataSetChanged()
    }

}