package com.sample.phonebook.home

import androidx.lifecycle.MutableLiveData
import com.sample.phonebook.common.BaseManager
import com.sample.phonebook.home.model.HomeModel
import com.sample.phonebook.retrofit.RetrofitClientInstance
import com.sample.phonebook.retrofit.interfaces.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeManger : BaseManager() {

    companion object {

        fun fetchUsersData(): MutableLiveData<List<HomeModel>> {

            var usersData: MutableLiveData<List<HomeModel>> = MutableLiveData()
            RetrofitClientInstance.retrofitInstance?.create(APIService::class.java)
                ?.getUsersData()?.enqueue(object : Callback<List<HomeModel>> {
                    override fun onFailure(call: Call<List<HomeModel>>, t: Throwable) {
                        usersData.postValue(null)
                    }

                    override fun onResponse(
                        call: Call<List<HomeModel>>,
                        response: Response<List<HomeModel>>
                    ) {
                        usersData.postValue(response.body())
                    }

                })
            return usersData
        }
    }

}