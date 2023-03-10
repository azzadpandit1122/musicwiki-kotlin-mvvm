package com.example.musicapp.repositorys

import androidx.lifecycle.MutableLiveData
import com.example.musicapp.models.TagInfoRequestModel
import com.example.musicapp.models.TagModel
import com.example.musicapp.models.TagRequestModel
import com.example.musicapp.models.albamRsponse.AlbamResponse
import com.example.musicapp.models.albaminfoResponse.AlbamInfoResponse
import com.example.musicapp.models.artistsResponse.ArtistResponse
import com.example.musicapp.models.tagInfoRespons.TagInfoModelResponse
import com.example.musicapp.models.trackResponse.TrackResonse
import com.example.musicapp.networking.ApiRequest
import com.example.musicapp.networking.RetroInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.HashMap

class UserRepository(private var apiCall: ApiRequest = RetroInstance.service) {
    private val TAG = UserRepository::class.java.simpleName
    var tagResult: MutableLiveData<TagModel?> = MutableLiveData()
    var tagInfoResult: MutableLiveData<TagInfoModelResponse?> = MutableLiveData()
    var albamResponse: MutableLiveData<AlbamResponse?> = MutableLiveData()
    var artistResponse: MutableLiveData<ArtistResponse?> = MutableLiveData()
    var trackResonse: MutableLiveData<TrackResonse?> = MutableLiveData()
    var albamInfoResponse: MutableLiveData<AlbamInfoResponse?> = MutableLiveData()

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
    fun setArtistsRequest(apitoken: String, option: Map<String, String>) {
        apiCall.getArtits(apitoken,option).enqueue(object : Callback<ArtistResponse> {
            override fun onResponse(
                call: Call<ArtistResponse>,
                response: Response<ArtistResponse>
            ) {
                if (response.isSuccessful) {
                    artistResponse.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<ArtistResponse>, t: Throwable) {
                t.printStackTrace()
                artistResponse.postValue(null)
            }
        })

    }

    fun getArtistsResult(): MutableLiveData<ArtistResponse?> {
        return artistResponse
    }

    fun setTrackRequest(apiToken: String, optiontrack: HashMap<String, String>) {
        apiCall.getTracks(apiToken,optiontrack).enqueue(object : Callback<TrackResonse> {
            override fun onResponse(
                call: Call<TrackResonse>,
                response: Response<TrackResonse>
            ) {
                if (response.isSuccessful) {
                    trackResonse.postValue(response.body())
                }
            }
            override fun onFailure(call: Call<TrackResonse?>, t: Throwable) {
                t.printStackTrace()
                trackResonse.postValue(null)
            }
        })
    }

    fun getTrackResult(): MutableLiveData<TrackResonse?> {
        return trackResonse
    }

    fun setAlbamInfoRequest(apiToken: String, option: HashMap<String, String>) {
        apiCall.getAlbamInfo(apiToken,option).enqueue(object : Callback<AlbamInfoResponse> {
            override fun onResponse(
                call: Call<AlbamInfoResponse>,
                response: Response<AlbamInfoResponse>
            ) {
                if (response.isSuccessful) {
                    albamInfoResponse.postValue(response.body())
                }
            }
            override fun onFailure(call: Call<AlbamInfoResponse?>, t: Throwable) {
                t.printStackTrace()
                albamInfoResponse.postValue(null)
            }
        })
    }

    fun getAlbamInfoResult(): MutableLiveData<AlbamInfoResponse?> {
        return albamInfoResponse
    }
}