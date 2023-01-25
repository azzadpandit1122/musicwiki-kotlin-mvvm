package com.example.musicapp.models.alrtistIntoResponse


import com.google.gson.annotations.SerializedName

data class Artist(
    val image: List<Image>,
    val listeners: String,
    val mbid: String,
    val name: String,
    val streamable: String,
    val url: String
)