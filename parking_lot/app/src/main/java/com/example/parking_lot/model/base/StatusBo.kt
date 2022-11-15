package com.example.parking_lot.model.base

import java.io.Serializable

/**
 * 異常資料
 *
 * provided by Ricky
 * posted by Jasper
 */
class StatusBo : Serializable {
    var systemId: String? = null
    var errorCode: String? = null
    var statusDesc: String? = null
    var txTime: String? = null
    var statusCode: String? = null
    var messageCode: String? = null
    var exception: Throwable? = null
    var exceptionMessage: String? = null
    var txStatus: String? = null
    var errorDesc: String? = null
    var validateMap: Map<String, String>? = null

    val isSuccess: Boolean
        get() = (TX_STATUS_SUCCESS == txStatus) || (TX_STATUS_RESERVED == txStatus)

    val isCancel: Boolean
        get() = (TX_STATUS_CANCEL == txStatus)

    fun hasValidateMap(): Boolean {
        return statusCode == STATUS_CODE_0109
    }

    companion object {
        private const val STATUS_CODE_0109 = "0109"
        private const val COMMON_STATUS_CODE_ERROR = 9999
        private const val COMMON_SYSTEM_ID = "DBS"
        private const val COMMON_CLIENT_TIME = ""
        const val COMMON_DESC_ERROR = "目前網路連線不穩"
        const val COMMON_ERROR_CODE_ERROR = "9999"
        const val TX_STATUS_SUCCESS = "SUCCESS"
        const val TX_STATUS_FAIL = "FAIL"
        const val TX_STATUS_RESERVED = "RESERVED"
        const val TX_STATUS_CANCEL = "CANCEL"

        fun getCommonErrorStatusBO(): StatusBo = StatusBo().apply {
            systemId = COMMON_SYSTEM_ID
            statusDesc = COMMON_DESC_ERROR
            txTime = COMMON_CLIENT_TIME
            statusCode = COMMON_STATUS_CODE_ERROR.toString()
            errorCode = COMMON_ERROR_CODE_ERROR
        }
    }
}
