package com.example.musicapp.models.trackResponse


import com.google.gson.annotations.SerializedName

data class Streamable(
    val fulltrack: String,
    @SerializedName("#text")
    val text: String
)