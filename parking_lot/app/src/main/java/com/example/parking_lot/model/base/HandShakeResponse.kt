package com.example.parking_lot.model.base

import com.example.parking_lot.model.error.ValidateError
import com.google.gson.annotations.SerializedName

/**
 * Created by Ricky on 4/8/21.
 */
data class HandShakeResponse(
    @SerializedName("systemId") val systemId: String, // 系統代碼，錯誤使用
    @SerializedName("statusCode") val statusCode: String, // 狀態代碼
    @SerializedName("statusDesc") val statusDesc: String, // 狀態訊息，錯誤使用
    @SerializedName("clientTime") val clientTime: String, // server side 下發時間用
    @SerializedName("rsData") val rsData: HandShakeWBResponse, // 該交易的下傳資料
    @SerializedName("validateError") val validateError: ValidateError, // 欄位檢核錯誤，於statusCode為0109使用
) : BaseModel()