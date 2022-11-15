package com.example.parking_lot.utils

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.os.ResultReceiver
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 * this is about ui's function<br/>
 * like dp2px or show/hide keyboard
 */
object UiUtils {

    fun getWidthByScreen(context: Context, padding: Int): Int {
        val displayMetrics = context.resources.displayMetrics
        return (displayMetrics.widthPixels - padding * displayMetrics.density * 2).toInt()
    }

    fun dpToPx(dp: Int): Int {
        return (dp * Resources.getSystem().displayMetrics.density + 0.5).toInt()
    }

    fun pxToDp(px: Int): Int {
        return (px / Resources.getSystem().displayMetrics.density).toInt()
    }

    /**
     * 根据item的大小(弧的长度),和item对应的旋转角度,计算出滑轮轴的半径
     * @param radian
     * @param degree
     * @return
     */
    fun radianToRadio(radian: Int, degree: Float): Double {
        return radian * 180.0 / (degree * Math.PI)
    }

    fun isShowKeyboard(context: Context, v: View): Boolean {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        return imm.isActive(v)
    }

    fun showKeyboard(view: View) {
        val inputManager = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT,
            object : ResultReceiver(null) {
                override fun onReceiveResult(resultCode: Int, resultData: Bundle) {
                }
            }
        )
    }

    fun hideKeyboard(context: Context, view: View) {
        try {
            val inputMethodManager = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        } catch (e: Exception) {
            LogUtils.d(Log.getStackTraceString(e))
        }
    }

    fun hideKeyboard(activity: Activity?) {
        activity?.currentFocus?.let {
            val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }

}