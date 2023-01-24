package com.example.musicapp.models.albamRsponse


import com.google.gson.annotations.SerializedName

data class Albums(
    val album: List<Album>,
    @SerializedName("@attr")
    val attr: AttrX
)