package com.example.musicapp.models.albamRsponse


import com.google.gson.annotations.SerializedName

data class Album(
    val artist: Artist,
    @SerializedName("@attr")
    val attr: Attr,
    val image: List<Image>,
    val mbid: String,
    val name: String,
    val url: String
)