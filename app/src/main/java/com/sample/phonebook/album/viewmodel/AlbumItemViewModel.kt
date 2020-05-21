package com.sample.phonebook.album.viewmodel

import com.sample.phonebook.album.model.AlbumModel

class AlbumItemViewModel(var model: AlbumModel?, var listener: AlbumItemViewModelListener?) {

    fun onRowClick() {
        listener?.onRowClicked(model)
    }

    interface AlbumItemViewModelListener {
        fun onRowClicked(model: AlbumModel?)
    }
}