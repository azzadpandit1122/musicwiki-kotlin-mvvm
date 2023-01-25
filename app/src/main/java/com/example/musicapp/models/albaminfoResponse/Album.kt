package com.example.musicapp.models.albaminfoResponse


import com.google.gson.annotations.SerializedName

data class Album(
    val artist: String,
    val image: List<Image>,
    val mbid: String,
    val name: String,
    val streamable: String,
    val url: String
)