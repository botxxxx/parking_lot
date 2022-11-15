package com.example.parking_lot.model.base

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by Ricky on 4/8/21.
 */
data class Request(
    @SerializedName("trackingId") val trackingId: String, // 追蹤碼用於阻擋重複的request
//    @SerializedName("sessionId") val sessionId: String, //每次連線時產生Session的Id
    @SerializedName("txnUid") val txnUid: String? = null, //該功能的uuid，每次前往該功能會自動產生
//    @SerializedName("uuid") val uuid: String, // 廣告ID
//    @SerializedName("model") val model: String, // 手機裝置型號
//    @SerializedName("appVersion") val appVersion: String, // APP的版本,
//    @SerializedName("version") val version: String, // OS的版本,
    @SerializedName("clientTime") val clientTime: String? = Calendar.getInstance().timeInMillis.toString(), // 用戶端裝置的時間
    @SerializedName("rqData") var rqData: String? = null, // 該交易的上送資料
//    @SerializedName("platform") val platform: String = "Android", // 該裝置平台，例Android，IOS
//    @SerializedName("locale") val locale: String = "zh_TW", // 語系,預設zh_TW
//    @SerializedName("securityVersion") val securityVersion: String = "0" // 資料加密版本 ") 0 = 沒有白箱, 沒有私鑰
) : BaseModel()