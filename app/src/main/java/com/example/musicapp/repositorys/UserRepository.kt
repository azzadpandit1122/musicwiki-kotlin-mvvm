package com.example.musicapp.repositorys

import androidx.lifecycle.MutableLiveData
import com.example.musicapp.models.TagInfoRequestModel
import com.example.musicapp.models.TagModel
import com.example.musicapp.models.TagRequestModel
import com.example.musicapp.models.albamRsponse.AlbamResponse
import com.example.musicapp.models.tagInfoRespons.TagInfoModelResponse
import com.example.musicapp.networking.ApiRequest
import com.example.musicapp.networking.RetroInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(private var apiCall: ApiRequest = RetroInstance.service) {
    private val TAG = UserRepository::class.java.simpleName
    var tagResult: MutableLiveData<TagModel?> = MutableLiveData()
    var tagInfoResult: MutableLiveData<TagInfoModelResponse?> = MutableLiveData()
    var albamResponse: MutableLiveData<AlbamResponse?> = MutableLiveData()

    fun tagsListRequest(tag: TagRequestModel) {
        println(tag.toString())
        apiCall.getTagsList(tag.api_key.toString(), tag.format.toString())
            .enqueue(object : Callback<TagModel> {
                override fun onResponse(call: Call<TagModel>, response: Response<TagModel>) {
                    if (response.isSuccessful) {
                        tagResult.postValue(response.body())
                        println("respose is come ")
                        println(tagResult.toString())
                    }
                }

                override fun onFailure(call: Call<TagModel>, t: Throwable) {
                    t.printStackTrace()
                    tagResult.postValue(null)
                }
            })

    }

    fun getTagsResult(): MutableLiveData<TagModel?> {
        return tagResult
    }

    fun tagInfoRequest(tagInfoModel: TagInfoRequestModel,option : Map<String,String>) {
        apiCall.getTagsInfo(tagInfoModel.api_key.toString(),option).enqueue(object : Callback<TagInfoModelResponse> {
            override fun onResponse(
                call: Call<TagInfoModelResponse>,
                response: Response<TagInfoModelResponse>
            ) {
                if (response.isSuccessful) {
                    tagInfoResult.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<TagInfoModelResponse>, t: Throwable) {
                t.printStackTrace()
                tagInfoResult.postValue(null)
            }
        })
    }

    fun getTagsInfoResult(): MutableLiveData<TagInfoModelResponse?> {
        return tagInfoResult
    }

    fun setAlbamRequest(apitoken: String, option: Map<String, String>) {
        apiCall.getAlbams(apitoken,option).enqueue(object : Callback<AlbamResponse> {
            override fun onResponse(
                call: Call<AlbamResponse>,
                response: Response<AlbamResponse>
            ) {
                if (response.isSuccessful) {
                    albamResponse.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<AlbamResponse>, t: Throwable) {
                t.printStackTrace()
                albamResponse.postValue(null)
            }
        })

    }

    fun getAlbamResult(): MutableLiveData<AlbamResponse?> {
        return albamResponse
    }
}