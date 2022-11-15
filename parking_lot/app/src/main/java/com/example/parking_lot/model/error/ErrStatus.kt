package com.example.parking_lot.model.error

import kotlinx.serialization.Serializable
/**
 * Created by Ricky on 4/9/21.
 */
@Serializable
class ErrStatus {
    companion object {
        /** 成功狀態碼:0 其他為失敗  */
        private const val SUCCESS_STATUS_CODE = "0"
    }

    var systemId: String? = null
    var errorCode = SUCCESS_STATUS_CODE
    var severity: SeverityType = SeverityType.INFO
    var errorDesc = ""
}