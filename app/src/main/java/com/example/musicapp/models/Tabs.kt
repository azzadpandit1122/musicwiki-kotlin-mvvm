package com.example.musicapp.models

import com.google.gson.annotations.SerializedName

data class TagModel(

    @SerializedName("toptags") var toptags: Toptags? = Toptags()

)

data class Tag1(

    @SerializedName("count") var count: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null

)

data class attr1(

    @SerializedName("artist") var artist: String? = null,
    @SerializedName("album") var album: String? = null

)


data class Toptags(

    @SerializedName("tag") var tag: ArrayList<Tag1> = arrayListOf(),
    @SerializedName("@attr") var attr: attr1? = attr1()

)