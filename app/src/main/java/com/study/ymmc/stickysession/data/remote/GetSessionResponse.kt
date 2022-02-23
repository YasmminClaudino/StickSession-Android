package com.study.ymmc.stickysession.data.remote

import com.google.gson.annotations.SerializedName

data class GetSessionResponse(
    @SerializedName("answer") val answer: Int,
    @SerializedName("columns") val nameColumns: List<ColumnResponse>,
    @SerializedName("description") val description: String,
    @SerializedName("highlight") val highlight: String,
    @SerializedName("id") val id: String,
    @SerializedName("meetingId") val meetingId: String,
    @SerializedName("name") val name: String
)
data class ColumnResponse(
    @SerializedName("color") val color: String,
    @SerializedName("name") val name: String

)