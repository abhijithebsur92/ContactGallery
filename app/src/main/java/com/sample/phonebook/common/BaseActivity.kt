package com.sample.phonebook.common

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.sample.phonebook.common.ui.BaseFragment
import com.sample.phonebook.utils.NavigationController

open class BaseActivity : FragmentActivity() {

    var navigationController: NavigationController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }
    /**
     * Initialization related code
     */
    private fun init() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        navigationController = NavigationController(this, supportFragmentManager)
    }

    /**
     * Type of modules in the supplier app
     */
    interface ModuleType {
        companion object {
            val NONE = -1
            val HOME = 1
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        val currentFragment = supportFragmentManager.findFragmentById(android.R.id.content)
        when(currentFragment){
            is BaseFragment ->{
                currentFragment.onWindowFocusChange(hasFocus)
            }
        }
    }
}