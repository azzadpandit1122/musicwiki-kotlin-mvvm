package com.example.musicapp.models.albaminfoResponse


import com.google.gson.annotations.SerializedName

data class OpensearchQuery(
    val role: String,
    val searchTerms: String,
    val startPage: String,
    @SerializedName("#text")
    val text: String
)