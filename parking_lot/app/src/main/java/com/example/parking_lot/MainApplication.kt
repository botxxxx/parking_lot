package com.example.parking_lot

import android.app.Application
import com.example.parking_lot.manager.NetworkManager

/**
 * Created by Ricky on 3/25/21.
 */
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        applicationContext?.run {
            initNetworkModule()
        }
    }

    private fun initNetworkModule() {
        NetworkManager.init(DBSConfig.URL_LOGIN_SERVER)
    }
}