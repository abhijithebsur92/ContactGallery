package com.sample.phonebook.home.model

import com.google.gson.annotations.SerializedName

class HomeResponse(
    @SerializedName("")
    var users: Array<HomeModel>
) {
}