package com.sample.phonebook.home.ui

import android.os.Bundle
import android.os.PersistableBundle
import com.sample.phonebook.common.BaseActivity

class HomeActivity : BaseActivity(){


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigationController?.launchHomeScreen()
    }
}