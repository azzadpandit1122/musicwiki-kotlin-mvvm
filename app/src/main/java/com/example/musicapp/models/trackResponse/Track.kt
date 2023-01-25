package com.example.musicapp.models.trackResponse


import com.google.gson.annotations.SerializedName

data class Track(
    val artist: Artist,
    @SerializedName("@attr")
    val attr: AttrX,
    val duration: String,
    val image: List<Image>,
    val mbid: String,
    val name: String,
    val streamable: Streamable,
    val url: String
)