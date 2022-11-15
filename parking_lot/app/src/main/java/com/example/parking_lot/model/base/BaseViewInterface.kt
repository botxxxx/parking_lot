package com.example.parking_lot.model.base

import android.content.Context
import kotlinx.coroutines.CoroutineScope

/**
 * Created by Ricky on 2021/5/26.
 */
interface BaseViewInterface {
    fun getContext(): Context?
    fun getLifeCycleScope(): CoroutineScope
}