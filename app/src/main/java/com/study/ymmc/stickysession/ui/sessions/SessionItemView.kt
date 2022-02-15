package com.study.ymmc.stickysession.ui.sessions

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.study.ymmc.stickysession.R
import com.study.ymmc.stickysession.model.Session

class SessionItemView(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var textTitle: TextView = itemView.findViewById(R.id.textSessionTitle)
    fun updateData(session: Session) {
        textTitle.text = session.name
    }
}
