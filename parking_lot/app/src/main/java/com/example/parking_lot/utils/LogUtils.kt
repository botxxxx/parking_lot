package com.example.parking_lot.utils

import android.util.Log
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy


object LogUtils {
    //public static final boolean isOnline = false;
    const val VERBOSE = 2
    const val DEBUG = 3
    const val INFO = 4
    const val WARN = 5
    const val ERROR = 6
    const val ASSERT = 7
    private const val TAG = "DBS"

    init {
        val formatStrategy: FormatStrategy = PrettyFormatStrategy.newBuilder()
            .tag(TAG) // 全局tag
            .build()
        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
    }
//
//    @JvmStatic
//    fun init() {
//        val formatStrategy: FormatStrategy = PrettyFormatStrategy.newBuilder()
//            .tag(TAG) // 全局tag
//            .build()
//        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
//    }

    @JvmStatic
    fun w(message: String) {
        if (AppUtils.isDebug()) {
            Log.w("message DEBUG", "message")
            Logger.w(message)
        }
    }

    @JvmStatic
    fun w(tag: String, message: String) {
        if (AppUtils.isDebug()) {
            Logger.w(tag, message)
        }
    }

    @JvmStatic
    fun isLoggable(tag: String?, level: Int): Boolean {
        return Log.isLoggable(tag, level)
    }

    @JvmStatic
    fun v(tag: String, message: String) {
        if (AppUtils.isDebug()) {
            Logger.v(tag, message)
        }
    }

    @JvmStatic
    fun v(message: String) {
        if (AppUtils.isDebug()) {
            Logger.v(message)
        }
    }

    @JvmStatic
    fun d(tag: String, message: String) {
        if (AppUtils.isDebug()) {
            Logger.d(tag, message)
        }
    }

    @JvmStatic
    fun d(sw: Boolean, message: String, vararg args: Any?) {
        if (sw) {
            Logger.d(message, args)
        }
    }

    @JvmStatic
    fun d(message: String) {
        if (AppUtils.isDebug()) {
            Logger.d(message)
        }
    }

    @JvmStatic
    fun e(tag: String, message: String) {
        if (AppUtils.isDebug()) {
            Logger.e(tag, message)
        }
    }

    @JvmStatic
    fun e(message: String, throwable: Throwable) {
        if (AppUtils.isDebug()) {
            Logger.e(message, throwable)
        }
    }

    @JvmStatic
    fun e(message: String) {
        if (AppUtils.isDebug()) {
            Logger.e(message)
        }
    }

    @JvmStatic
    fun e(throwable: Throwable) {
        if (AppUtils.isDebug()) {
            Logger.e(throwable.toString())
        }
    }

    @JvmStatic
    fun json(message: String) {
        if (AppUtils.isDebug()) {
            Logger.json(message)
        }
    }

    @JvmStatic
    fun println(str: String) {
        if (AppUtils.isDebug()) {
            println(str)
        }
    }

    @JvmStatic
    fun printf(format: String, vararg args: Any) {
        if (AppUtils.isDebug()) {
            System.out.printf(format, *args)
        }
    }

    @JvmStatic
    fun e(tag: String, msg: String, tr: Throwable) {
        if (AppUtils.isDebug()) {
            Logger.e(tag, msg, tr)
        }
    }
}