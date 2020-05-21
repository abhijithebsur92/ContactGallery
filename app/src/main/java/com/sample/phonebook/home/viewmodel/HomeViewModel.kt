package com.sample.phonebook.home.viewmodel

import android.app.Application
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.sample.phonebook.R
import com.sample.phonebook.common.viewmodel.BaseViewModel
import com.sample.phonebook.home.HomeManger
import com.sample.phonebook.home.model.HomeModel
import com.sample.phonebook.utils.NetworkUtils

class HomeViewModel(app: Application) : BaseViewModel(app) {

    var items: MutableLiveData<List<HomeModel>> = MutableLiveData()
    var mediatorLiveData: MediatorLiveData<List<HomeModel>> = MediatorLiveData()

    fun fetchUsersData() {

        if (NetworkUtils.isNetworkAvailable(getApplication())) {
            showProgressView()
            mediatorLiveData.addSource(HomeManger.fetchUsersData()) { response ->

                if (response?.isNotEmpty() == true) {
                    showContentView()
                    items.postValue(response)
                } else {
                    showErrorMessage(getApplication<Application>().getString(R.string.no_data))
                }

            }
        } else {
            showErrorMessage(getApplication<Application>().getString(R.string.no_internet_message))
        }
    }
}