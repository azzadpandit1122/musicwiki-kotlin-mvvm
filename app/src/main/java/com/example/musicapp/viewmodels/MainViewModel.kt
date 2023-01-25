package com.example.musicapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.musicapp.models.*
import com.example.musicapp.models.tagInfoRespons.TagInfoModelResponse
import com.example.musicapp.models.TagRequestModel
import com.example.musicapp.models.albamRsponse.AlbamResponse
import com.example.musicapp.models.artistsResponse.ArtistResponse
import com.example.musicapp.repositorys.UserRepository
import com.google.gson.JsonObject

class MainViewModel(private var userRepo: UserRepository = UserRepository()) : ViewModel() {

    var tagsRespose: MutableLiveData<TagModel?> = MutableLiveData()
    var tagsInfoRespose: MutableLiveData<TagInfoModelResponse?> = MutableLiveData()
    var albamResponse: MutableLiveData<AlbamResponse?> = MutableLiveData()
    var artistResponse: MutableLiveData<ArtistResponse?> = MutableLiveData()

    init {
        tagsRespose = userRepo.getTagsResult()
        tagsInfoRespose = userRepo.getTagsInfoResult()
        albamResponse = userRepo.getAlbamResult()
        artistResponse = userRepo.getArtistsResult()
    }

    fun setTagsRequest(tag: TagRequestModel) {
        userRepo.tagsListRequest(tag)
    }

    fun getTagsListResponse(): LiveData<TagModel?> {
        return tagsRespose
    }

    fun setTagInfoRequest(tagInfoModel: TagInfoRequestModel,option : Map<String,String>){
        userRepo.tagInfoRequest(tagInfoModel,option)
    }

    fun getTagInfoResponse():LiveData<TagInfoModelResponse?>{
        return tagsInfoRespose
    }

    fun setAlbamsRequest(apitoken: String,option : Map<String,String>){
        userRepo.setAlbamRequest(apitoken,option)
    }

    fun getAlbamResponse():LiveData<AlbamResponse?>{
        return albamResponse
    }

    fun setArtisitRequest(apitoken: String,option : Map<String,String>){
        userRepo.setArtistsRequest(apitoken,option)
    }

    fun getArtisitResponse():LiveData<ArtistResponse?>{
        return artistResponse
    }


}
