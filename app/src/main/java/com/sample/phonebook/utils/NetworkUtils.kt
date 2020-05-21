package com.sample.phonebook.utils

import android.content.Context
import android.net.ConnectivityManager

class NetworkUtils {

    companion object {

        /**
         * Utility method to check is network available
         *
         * @param context:Context
         * @return:Boolean true if network is available else returns false
         */
        fun isNetworkAvailable(context: Context): Boolean {
            val conn: ConnectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = conn.activeNetworkInfo

            return networkInfo?.isConnected == true
        }

    }
}