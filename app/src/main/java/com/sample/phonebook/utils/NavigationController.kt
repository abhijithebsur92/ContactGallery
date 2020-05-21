package com.sample.phonebook.utils

import android.content.Context
import androidx.fragment.app.FragmentManager
import com.sample.phonebook.album.model.AlbumModel
import com.sample.phonebook.album.ui.AlbumFragment
import com.sample.phonebook.albumdetails.ui.AlbumDetailsFragment
import com.sample.phonebook.home.ui.HomeFragment

class NavigationController(var context: Context, var fragmentManager: FragmentManager) {

    fun launchHomeScreen() {
        FragmentHelper.add(fragmentManager, android.R.id.content, HomeFragment())
    }

    fun launchAlbumsScreen() {
        FragmentHelper.addToBackStackAndReplace(fragmentManager, android.R.id.content, AlbumFragment())
    }

    fun launchAlbumDetailScreen(model : AlbumModel?) {
        FragmentHelper.addToBackStackAndReplace(fragmentManager, android.R.id.content, AlbumDetailsFragment.newInstance(model))
    }

}