package com.example.parking_lot.utils

import android.content.Context
import android.content.pm.ApplicationInfo

/**
 * Created by Ricky on 2021/9/7.<br/>
 * use replace BuildConfig isDebug
 */
object AppUtils {
    private var isDebug: Boolean? = null
    lateinit var flavor: String
    lateinit var versionName: String
    fun isDebug(): Boolean {
        return isDebug?.run {
            this
        } ?: kotlin.run { false }
    }

    fun init(context: Context, flavor: String, versionName: String) {
        syncIsDebug(context)
        AppUtils.flavor = flavor
        AppUtils.versionName = versionName
    }

    private fun syncIsDebug(context: Context) {
        if (isDebug == null) {
            context.applicationInfo?.let {
                isDebug = (it.flags and ApplicationInfo.FLAG_DEBUGGABLE) != 0
            }
        }
    }
}