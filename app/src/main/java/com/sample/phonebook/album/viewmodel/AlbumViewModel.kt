package com.sample.phonebook.album.viewmodel

import android.app.Application
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.sample.phonebook.R
import com.sample.phonebook.album.AlbumManager
import com.sample.phonebook.album.model.AlbumModel
import com.sample.phonebook.common.viewmodel.BaseViewModel
import com.sample.phonebook.home.HomeManger
import com.sample.phonebook.home.model.HomeModel
import com.sample.phonebook.utils.NetworkUtils

class AlbumViewModel(app: Application) : BaseViewModel(app) {

    var items: MutableLiveData<List<AlbumModel>> = MutableLiveData()
    var mediatorLiveData: MediatorLiveData<List<AlbumModel>> = MediatorLiveData()

    fun fetchAlbumsData() {

        if (NetworkUtils.isNetworkAvailable(getApplication())) {
            showProgressView()
            mediatorLiveData.addSource(AlbumManager.fetchAlbumsData()) { response ->

                if (response?.isNotEmpty() == true) {
                    showContentView()
                    //generate data
                    items.postValue(response)
                } else {
                    showErrorMessage(getApplication<Application>().getString(R.string.no_data))
                }

            }
        }
    }
}