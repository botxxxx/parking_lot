package com.example.parking_lot.utils

import android.annotation.SuppressLint
import android.content.Context
import com.example.parking_lot.activiry.LoadingActivity
import com.jeremyliao.liveeventbus.LiveEventBus

/**
 * Loading動畫
 * @author Hongren
 */
@SuppressLint("StaticFieldLeak")
object Loading {
    var isShown = false
    fun show(context: Context?) {
        if (!isShown) {
            LoadingActivity.show(context)
        } else {
            LiveEventBus.get(LoadingActivity.KEY_EVENT_LOADING, Boolean::class.java).post(LoadingActivity.SHOW)
        }
    }

    fun hide() {
        LiveEventBus.get(LoadingActivity.KEY_EVENT_LOADING, Boolean::class.java).post(LoadingActivity.HIDE)
    }

}