package com.sample.phonebook.common.viewmodel

import android.app.Application
import androidx.databinding.ObservableField


open class BaseViewModel(app: Application) : AndroidViewModel(app) {

    var showContentView: Boolean = true

    var showEmptyView: Boolean = false

    var showProgressView: Boolean = false

    var showHeaderView: Boolean = true

    var headerTitle: String = ""

    var headerSubTitle: String = ""

    var errorMessage: String = ""

    private var showHeaderSubTitle: ObservableField<Boolean> = ObservableField(false)

    fun showContentView() {
        showContentView = true
        showEmptyView = false
        showProgressView = false
        notifyChange()
    }

    fun showProgressView() {
        showEmptyView = false
        showProgressView = true
        notifyChange()
    }

    fun showEmptyView() {
        showContentView = false
        showEmptyView = true
        showProgressView = false
        notifyChange()
    }

    fun headerTitle(title: String) {
        headerTitle = title
        notifyChange()
    }

    fun headerSubTitle(subTitle: String) {
        headerSubTitle = subTitle
        showHeaderSubTitle.set(subTitle.isNotEmpty())
        notifyChange()
    }

    fun showErrorMessage(message: String) {
        errorMessage = message
        showEmptyView()
        notifyChange()
    }

    fun getShowHeaderSubTitle(): Boolean {
        return showHeaderSubTitle.get()!!
    }

}