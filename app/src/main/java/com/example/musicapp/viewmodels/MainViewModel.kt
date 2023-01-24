package com.example.musicapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.musicapp.models.*
import com.example.musicapp.models.tagInfoRespons.TagInfoModelResponse
import com.example.musicapp.models.TagRequestModel
import com.example.musicapp.repositorys.UserRepository

class MainViewModel(private var userRepo: UserRepository = UserRepository()) : ViewModel() {

    var tagsRespose: MutableLiveData<TagModel?> = MutableLiveData()
    var tagsInfoRespose: MutableLiveData<TagInfoModelResponse?> = MutableLiveData()

    init {
        tagsRespose = userRepo.getTagsResult()
        tagsInfoRespose = userRepo.getTagsInfoResult()
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




}
