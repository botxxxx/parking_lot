package com.example.parking_lot.utils

import android.util.Log
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import java.lang.reflect.Type
import java.math.BigDecimal

/**
 * Created by Ricky on 4/8/21.
 */
/**
 * 為 BigDecimal 接的欄位移除多餘符號，避免部分金額欄位 API 傳下來都是 ###,###,0 格式轉不出來
 *
 * Created by Rebecca on 2018/1/16.
 */
class BigDecimalDeserializer : JsonDeserializer<BigDecimal?> {
    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): BigDecimal? {
        var result: BigDecimal? = null
        var str = json.asString
        try {
            str = str.replace("$", "")
            str = str.replace(",", "")
            result = BigDecimal(str)
        } catch (e: Exception) {
            Log.e(BigDecimalDeserializer::class.java.simpleName, e.toString())
        }
        return result
    }
}