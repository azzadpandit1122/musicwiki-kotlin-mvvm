package com.example.musicapp.models

/*

method:album.gettoptags
artist:radiohead
album:the%20bends
api_key:{{tokenKey}}
format:json

*/

data class TagRequestModel(
    var method: String? = null,
    var artist: String? = null,
    var album: String? = null,
    var api_key: String? = null,
    var format: String? = null
)