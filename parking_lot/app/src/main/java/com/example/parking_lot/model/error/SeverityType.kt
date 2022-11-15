package com.example.parking_lot.model.error

/**
 * Created by Ricky on 4/9/21.
 */
enum class SeverityType(private val value: String, val memo: String) {
    INFO("INFO", "狀態等級-資訊"),
    WARN("WARN", "狀態等級-警告"),
    ERROR("ERROR", "狀態等級-錯誤"),
    TIMEOUT("TIMEOUT", "狀態等級-逾時"),
    FATAL("FATAL", "狀態等級-異常"),
    UNKNOWN("UNKNOWN", "未知");

    /**
     * 依據代碼取得SourceType
     *
     * @return
     */
    open fun find(value: String): SeverityType? {
        for (type in values()) {
            if (type.value == value) {
                return type
            }
        }
        return UNKNOWN
    }

}