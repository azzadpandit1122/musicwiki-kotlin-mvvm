package com.example.musicapp.models

//method=album.getinfo&
// api_key={{tokenKey}}&
// artist=radiohead&
// album=the%20bends&
// format=json
data class TagInfoRequestModel(
    var method: String? = null,
    var api_key: String? = null,
    var album: String? = null,
    var artist: String? = null,
    var format: String? = null
)