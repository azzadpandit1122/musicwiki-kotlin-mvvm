package com.example.musicapp.models.trackResponse


import com.google.gson.annotations.SerializedName

data class Image(
    val size: String,
    @SerializedName("#text")
    val text: String
)