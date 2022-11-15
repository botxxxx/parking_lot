package com.example.parking_lot.model.base

import com.google.gson.annotations.SerializedName

/**
 * Created by Ricky on 4/8/21.
 */
data class DBSResponse(
    val systemId: String, // 系統代碼，錯誤使用
    val statusCode: String, // 狀態代碼
    val statusDesc: String, // 狀態訊息，錯誤使用
    val messageCode: String, // 錯誤代碼, ui 顯示用
    val clientTime: String, // server side 下發時間用
    val rsData: String, // 該交易的下傳資料
    @SerializedName("rsErrorData") val errorData: RsErrorData?, // 錯誤訊息物件
) : BaseModel()

data class RsErrorData(
    val iconType: String, // icon type 0 = 小鈴鐺, 1 = 驚嘆號
    @SerializedName("leftBu") val leftButton: ButtonData, // 左邊按鈕
    @SerializedName("rightBu") val rightButton: ButtonData, // 左邊按鈕
    val content: ErrorContent, // icon type 0 = 小鈴鐺, 1 = 驚嘆號
    val errorFields: Map<String, String>, // 0109 map
) : BaseModel()

data class ButtonData(
    val text: String, // 按鈕文字
    val action: String, // 按鈕動作
) : BaseModel()

data class ErrorContent(
    val title: String, // 標題
    val subtitle: String, // 副標
) : BaseModel()

enum class ERROR_ICON_TYPE(val value: String) {
    ExclamationMark("1"),
    Ring("2")
}

enum class ALERT_ACTION(val value: String) {
    LoginPage("LoginPage"),//導到登入頁面
    RegisterPage("RegisterPage"),//導到註冊頁面
    Logout("Logout"),
    DISMISS("")//停留在原頁
}