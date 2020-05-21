package com.sample.phonebook.home.model

import com.google.gson.annotations.SerializedName
import com.sample.phonebook.common.model.BaseModel

class HomeModel(
    @SerializedName("id")
    var id : String?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("phone")
    var phone: String?,
    @SerializedName("email")
    var email: String?
) : BaseModel(){
}