package com.sample.phonebook.utils

import android.content.Context
import androidx.fragment.app.FragmentManager
import com.sample.phonebook.home.ui.HomeFragment

class NavigationController(var context: Context, var fragmentManager: FragmentManager) {

    fun launchHomeScreen() {
        val loginFragment = HomeFragment()
        FragmentHelper.add(fragmentManager, android.R.id.content, loginFragment)
    }

    fun launchAlbumsScreen() {
    }

}