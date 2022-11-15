package com.example.parking_lot.utils

import com.google.gson.*
import java.lang.reflect.Type
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * 從 Channel 那邊搬來備用的程式碼
 *
 * 針對Gson，將日期格式的字串，轉型為 java.util.Date
 *
 * @author Edward Tien
 */
class DateTypeDeserializer : JsonDeserializer<Date?> {
    /** 指定日期格式  */
    private val patterns = arrayOf(
        "yyyy/MM/dd", "yyyy MM dd HH:mm:ss SSS", "yyyy-MM-dd",
        "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    )

    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Date? {
        if (json !is JsonPrimitive) {
            throw JsonParseException("The date should be a string value")
        }
        val strValue = json.getAsJsonPrimitive().asString
        var date = localFormat(patterns, strValue)
        if (date == null) {
            date = enUsFormat(patterns, strValue)
        }
        return date
    }

    private fun localFormat(patterns: Array<String>, dateStr: String): Date? {
        for (pattern in patterns) {
            try {
                val format: DateFormat = SimpleDateFormat(pattern)
                return format.parse(dateStr)
            } catch (ignored: ParseException) {
                LogUtils.d("parsing error (ignored):${ignored}")
            }
        }
        return null
    }

    private fun enUsFormat(patterns: Array<String>, dateStr: String): Date? {
        for (pattern in patterns) {
            try {
                val format: DateFormat = SimpleDateFormat(pattern, Locale.US)
                return format.parse(dateStr)
            } catch (ignored: ParseException) {
                LogUtils.d("parsing error (ignored):${ignored}")
            }
        }
        return null
    }
}
