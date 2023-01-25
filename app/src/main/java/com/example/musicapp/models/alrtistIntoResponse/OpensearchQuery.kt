package com.example.musicapp.models.alrtistIntoResponse


import com.google.gson.annotations.SerializedName

data class OpensearchQuery(
    val role: String,
    val searchTerms: String,
    val startPage: String,
    @SerializedName("#text")
    val text: String
)