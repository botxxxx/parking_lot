package com.example.parking_lot.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.math.BigDecimal
import java.util.*

/**
 * Created by Ricky on 4/8/21.
 */
object GsonUtils {
    fun getGson(): Gson =
        GsonBuilder().setLenient().setPrettyPrinting()
            .registerTypeAdapter(BigDecimal::class.java, BigDecimalDeserializer())
            .registerTypeAdapter(Date::class.javaObjectType, DateTypeDeserializer())
            .create()
}