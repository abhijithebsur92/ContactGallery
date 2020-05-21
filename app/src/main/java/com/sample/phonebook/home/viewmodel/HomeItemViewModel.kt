package com.sample.phonebook.home.viewmodel

import com.sample.phonebook.home.model.HomeModel

class HomeItemViewModel(var model: HomeModel?, var listener: HomeItemViewModelListener?) {

    fun onRowClick() {
        listener?.onRowClicked(model)
    }

    interface HomeItemViewModelListener {
        fun onRowClicked(model: HomeModel?)
    }
}