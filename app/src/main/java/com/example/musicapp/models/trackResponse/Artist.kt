package com.example.musicapp.models.trackResponse


import com.google.gson.annotations.SerializedName

data class Artist(
    val mbid: String,
    val name: String,
    val url: String
)