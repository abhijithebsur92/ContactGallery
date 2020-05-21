package com.sample.phonebook.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class FragmentHelper {

    companion object {
        /**
         * Adds the fragment to back-stack
         *
         * @param mgr Fragment Manager
         * @param id container view Id
         * @param frgmt Fragment
         * @param tag optional tag name for the fragment
         */
        fun add(mgr: FragmentManager, id: Int, frgmt: Fragment, tag: String? = null) {
            mgr.beginTransaction().add(id, frgmt, tag).commitAllowingStateLoss()
        }

        /**
         * Adds the fragment to back-stack
         *
         * @param mgr Fragment Manager
         * @param id container view Id
         * @param frgmt Fragment
         * @param tag optional tag name for the fragment
         */
        fun addToBackStackAndAdd(
            mgr: FragmentManager,
            id: Int,
            frgmt: Fragment,
            tag: String? = null
        ) {
            mgr.beginTransaction().add(id, frgmt, tag).addToBackStack("").commitAllowingStateLoss()
        }
    }
}