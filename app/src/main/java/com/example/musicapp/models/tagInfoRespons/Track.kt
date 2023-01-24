package com.example.musicapp.models.tagInfoRespons


import com.google.gson.annotations.SerializedName

data class Track(
    val artist: Artist,
    @SerializedName("@attr")
    val attr: Attr,
    val duration: Int,
    val name: String,
    val streamable: Streamable,
    val url: String
)