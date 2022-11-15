package com.example.parking_lot.activiry

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.Bundle
import com.example.parking_lot.R
import com.jeremyliao.liveeventbus.LiveEventBus

/**
 * Created by Ricky on 2021/7/11.<br/>
 * loading activity<br/>
 * reference on https://github.com/JeremyLiao/LiveEventBus
 */
class LoadingActivity : BaseActivity() {
    companion object {
        const val KEY_EVENT_LOADING = "keyLoadingEvent"
        const val SHOW = true
        const val HIDE = false

        fun show(context: Context?) {
            context?.let {
                val intent = Intent(context, LoadingActivity::class.java)
                intent.flags = FLAG_ACTIVITY_NEW_TASK
                it.startActivity(intent)
            }
        }
    }

    private fun registerLifeEventBus() {
        LiveEventBus.get(KEY_EVENT_LOADING, Boolean::class.java).observeForever { isShowLoading ->
            if (isShowLoading) {
                show(this)
            } else {
                finish()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loading_view)
        registerLifeEventBus()
    }
}