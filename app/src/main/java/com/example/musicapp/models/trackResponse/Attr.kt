package com.example.musicapp.models.trackResponse


import com.google.gson.annotations.SerializedName

data class Attr(
    val page: String,
    val perPage: String,
    val tag: String,
    val total: String,
    val totalPages: String
)