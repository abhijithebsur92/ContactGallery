package com.sample.phonebook.retrofit.interfaces

import com.sample.phonebook.album.model.AlbumModel
import com.sample.phonebook.home.model.HomeModel
import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET("/users")
    fun getUsersData(): Call<List<HomeModel>>

    @GET("/photos")
    fun getAlbums(): Call<List<AlbumModel>>
}
