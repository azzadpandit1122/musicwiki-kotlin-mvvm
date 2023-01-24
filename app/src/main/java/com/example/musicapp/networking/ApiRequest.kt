package com.example.musicapp.networking

import com.example.musicapp.models.tagInfoRespons.TagInfoModelResponse
import com.example.musicapp.models.TagModel
import retrofit2.Call
import retrofit2.http.*


interface ApiRequest {

    @GET("2.0/?method=album.gettoptags&artist=radiohead&album=the%20bends")
    fun getTagsList(
        @Query("api_key") api_keys: String,
        @Query("format") formats: String,
    ):Call<TagModel>

//    method=album.getinfo&api_key={{tokenKey}}&artist=radiohead&album=the%20bends&format=json

    @GET("2.0/")
    fun getTagsInfo(
        @Query("api_key") api_keys: String,
        @QueryMap options: Map<String,String>
    ):Call<TagInfoModelResponse>


}