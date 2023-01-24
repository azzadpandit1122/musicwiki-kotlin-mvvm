package com.example.musicapp.networking

import com.example.musicapp.models.tagInfoRespons.TagInfoModelResponse
import com.example.musicapp.models.TagModel
import com.example.musicapp.models.albamRsponse.AlbamResponse
import retrofit2.Call
import retrofit2.http.*


interface ApiRequest {

    @GET("2.0/?method=album.gettoptags&artist=radiohead&album=the%20bends")
    fun getTagsList(
        @Query("api_key") api_keys: String,
        @Query("format") formats: String,
    ):Call<TagModel>

    @GET("2.0/")
    fun getTagsInfo(
        @Query("api_key") api_keys: String,
        @QueryMap options: Map<String,String>
    ):Call<TagInfoModelResponse>


    @GET("2.0/")
    fun getAlbams(
        @Query("api_key") api_keys: String,
        @QueryMap options: Map<String,String>
    ):Call<AlbamResponse>



}