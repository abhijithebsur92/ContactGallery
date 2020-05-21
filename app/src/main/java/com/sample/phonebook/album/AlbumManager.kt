package com.sample.phonebook.album

import androidx.lifecycle.MutableLiveData
import com.sample.phonebook.album.model.AlbumModel
import com.sample.phonebook.common.BaseManager
import com.sample.phonebook.home.model.HomeModel
import com.sample.phonebook.retrofit.RetrofitClientInstance
import com.sample.phonebook.retrofit.interfaces.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumManager : BaseManager(){

    companion object{
        fun fetchAlbumsData(): MutableLiveData<List<AlbumModel>> {

            var albumsData: MutableLiveData<List<AlbumModel>> = MutableLiveData()
            RetrofitClientInstance.retrofitInstance?.create(APIService::class.java)
                ?.getAlbums()?.enqueue(object : Callback<List<AlbumModel>> {
                    override fun onFailure(call: Call<List<AlbumModel>>, t: Throwable) {
                        albumsData.postValue(null)
                    }

                    override fun onResponse(
                        call: Call<List<AlbumModel>>,
                        response: Response<List<AlbumModel>>
                    ) {
                        albumsData.postValue(response.body())
                    }

                })
            return albumsData
        }
    }
}