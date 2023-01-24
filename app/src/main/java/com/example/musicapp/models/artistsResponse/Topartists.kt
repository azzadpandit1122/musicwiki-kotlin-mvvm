package com.example.musicapp.models.artistsResponse


import com.google.gson.annotations.SerializedName

data class Topartists(
    val artist: List<Artist>,
    @SerializedName("@attr")
    val attr: AttrX
)