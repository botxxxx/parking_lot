package com.example.parking_lot.api

import com.example.parking_lot.model.base.LOGIN_001
import com.google.gson.reflect.TypeToken

/**
 * Created by Ricky on 2021.09.10.<br/>
 * this is API Event Type<br/>
 * definition about api request/response
 */
enum class ApiEventType(val path: String, val tokenType: TypeToken<*>) {
//    // DBS Area
    LOGIN("login", object : TypeToken<LOGIN_001>() {}),// aes verify
//    LOGIN("LINO001/010", object : TypeToken<LINO001_010_Rs>() {}),// login
//    LOGOUT("LOUO001/010", object : TypeToken<BaseModel>() {}), // logout
//    REGISTER_CANCEL("LOUO001/020", object : TypeToken<BaseModel>() {}),
//
//    DEVICE_INFO("FSTHD001/010", object : TypeToken<FSTHD001_010_Rs>() {}),//取機號
//    DEVICE_INFO_GET_BRANCH_LIST("FSTHD001/020", object : TypeToken<FSTHD001_020_Rs>() {}),//取得分行別與名稱
//    DEVICE_INFO_BIND("FSTHD001/030", object : TypeToken<FSTHD001_030_Rs>() {}),//綁定機號
//    DEVICE_INFO_UNBIND("FSTHD002/010", object : TypeToken<BaseModel>() {}),//解除綁定機號
//
//    REGISTER("LINO002/010", object : TypeToken<LINO002_010_Rs>() {}), //register,
//    VERIFY_FACE_RESULT("LINO001/020", object : TypeToken<BaseModel>() {}),//[登入]人臉三方驗證
//    REGISTER_FACE_UPLOAD("LINO002/020", object : TypeToken<BaseModel>() {}),//註冊上傳
//    REQUEST_OTP("LINO002/040", object : TypeToken<LINO002_040_Rs>() {}),
//    VERIFY_OTP("LINO002/041", object : TypeToken<BaseModel>() {}),
//
//    // screenshot
//    UPLOAD_IMAGE("IMGUL001/010", object : TypeToken<BaseModel>() {}), //上傳圖檔
//
//    // transfer transaction
//    LOAD_USER_ACCOUNT("TWTX001/010", object : TypeToken<TWTX001_010_Rs>() {}),
//    GET_BALANCE_OR_ACCOUNT_NAME("TWTX001/020", object : TypeToken<TWTX001_020_Rs>() {}),
//    GET_ACCOUNT_NAME_OR_BALANCE("TWTX001/020", object : TypeToken<TWTX001_020_Rs>() {}),
//    SAVE_TRANSACTION("TWTX001/021", object : TypeToken<TWTX001_021_Rs>() {}),
//    CONFIRM_TRANSACTION_RETURN("TWTX001/accountInfo", object : TypeToken<TWTX001_accountInfo_Rs>() {}),
//    CONFIRM_TRANSACTION_LIST("TWTX001/030", object : TypeToken<TWTX001_030_Rs>() {}),
//    VERIFY_FACE_TO_OTP("TWTX001/040", object : TypeToken<TWTX001_040_Rs>() {}),
//    VERIFY_OTP_TO_INQUIRY("TWTX001/041", object : TypeToken<TWTX001_041_Rs>() {}),
//    VERIFY_FACE_TO_TELLER("TWTX001/042", object : TypeToken<BaseModel>() {}),
//    GET_TRANSFER_WAIT_COUNT("TWTX001/050", object : TypeToken<TWTX001_050_Rs>() {}),
//    TRANSFER_PAIR_CANCEL("TWTX001/051", object : TypeToken<TWTX001_051_Rs>() {}),
//    GET_TRANSFER_RESULT("TWTX001/060", object : TypeToken<TWTX001_060_Rs>() {}),
//    GET_BRANCH_LIST("BKCD001/020", object : TypeToken<BKCD001_020_Rs>() {}),
//
//    // transaction inquiry
//    LOAD_INQUIRY_ACCOUNT("TWDQ001/010", object : TypeToken<TWDQ001_010_Rs>() {}),
//    TRANSFER_INQUIRY_LIST("TWDQ001/020", object : TypeToken<TWDQ001_020_Rs>() {}),
//    KEEP_SESSION("HRBT01/010", object : TypeToken<BaseModel>() {}), // 續命
//    CHECK_REGISTER_STATUS("LINO002/030", object : TypeToken<LINO002_030_Rs>() {}),// 註冊更新交易狀態
//    GET_WAIT_COUNT_DOWN("LINO002/050", object : TypeToken<LINO002_050_Rs>() {}),//行員取得等待人數
//    GET_REGISTER_RESULT("LINO002/060", object : TypeToken<BaseModel>() {}),//註冊結果
//    TRANSFER_DONE_FIVE_RATE("STAR001/010", object : TypeToken<BaseModel>() {}),//轉帳完成 五星評價
//
//    FACE_VERIFY_ERROR_INFO("FACE001/010", object : TypeToken<BaseModel>() {}), //人臉驗證 找錯誤訊息
//    FACE_LOCK_NOTICE("FACE002/010", object : TypeToken<BaseModel>() {}), //人臉驗證 鎖定簡訊通知
//
//    // designated account settings
//    LOAD_DESIGNATED_ACCOUNT_LIST("DESO001/010", object : TypeToken<DESO001_010_Rs>() {}), // 取得既有的約轉帳號清單
//    LOAD_DESIGNATED_ACCOUNT_INFO("DESO001/accountInfo", object : TypeToken<DESO001_accountInfo_Rs>() {}), // 取得已經更動的約轉帳號清單
//    VERIFY_DESIGNATED_ACCOUNT("DESO001/020", object : TypeToken<DESO001_020_Rs>() {}), // 檢核新增的帳號
//    ADD_DESIGNATED_ACCOUNTS("DESO001/021", object : TypeToken<DESO001_021_Rs>() {}), // 送出新增的約轉帳號清單給中台暫存
//    DELETE_DESIGNATED_ACCOUNTS("DESO001/022", object : TypeToken<DESO001_022_Rs>() {}), // 送出刪除的約轉帳號清單給中台暫存
//    LOAD_DESIGNATED_CONFIRM_LIST("DESO001/030", object : TypeToken<DESO001_030_Rs>() {}), // 取得約轉確認清單
//    DESIGNATED_VERIFY_FACE("DESO001/040", object : TypeToken<DESO001_040_Rs>() {}), // 約轉人臉驗證
//    DESIGNATED_FACE_TO_TELLER("DESO001/041", object : TypeToken<BaseModel>() {}), // 約轉行員驗證
//    GET_DESIGNATED_WAIT_COUNT("DESO001/050", object : TypeToken<DESO001_050_Rs>() {}), // 約轉等待人數
//    DESIGNATED_PAIR_CANCEL("DESO001/051", object : TypeToken<DESO001_051_Rs>() {}), // 約轉mts取消
//    GET_DESIGNATED_RESULT("DESO001/060", object : TypeToken<DESO001_060_Rs>() {}), // 約轉結果頁
//
//    // user profile settings
//    GET_EMAIL_OTP_CODE("INFO001/email021", object : TypeToken<INFO001_email021_Rs>() {}), // 個資 - 取得電子信箱的otp驗證碼
//    VERIFY_EMAIL_OTP_CODE("INFO001/email022", object : TypeToken<BaseModel>() {}), // 個資 - 驗證電子信箱的otp驗證碼
//    GET_MOBILE_PHONE_OTP_CODE("INFO001/phone021", object : TypeToken<INFO001_phone021_Rs>() {}), // 個資 - 取得手機的otp驗證碼
//    VERIFY_MOBILE_PHONE_OTP_CODE("INFO001/phone022", object : TypeToken<BaseModel>() {}), // 個資 - 驗證手機的otp驗證碼
//    CANCEL_ALL_VERIFIED_OTP_CODE("INFO001/023", object : TypeToken<BaseModel>() {}), // 個資 - 註銷先前已驗證otp通過的電子信箱及手機號碼
//    LOAD_PROFILE_CONFIRM_LIST("INFO001/030", object : TypeToken<INFO001_030_Rs>() {}), // 基本資料確認頁清單
//    PROFILE_VERIFY_FACE("INFO001/040", object : TypeToken<INFO001_040_Rs>() {}), // 基本資料人臉驗證
//    PROFILE_OTP_TO_INQUIRY("INFO001/041", object : TypeToken<INFO001_041_Rs>() {}), //  基本資料OTP驗證
//    PROFILE_FACE_TO_TELLER("INFO001/042", object : TypeToken<BaseModel>() {}), //  基本資料行員驗證
//    GET_PROFILE_WAIT_COUNT("INFO001/050", object : TypeToken<INFO001_050_Rs>() {}), // 基本資料等待人數
//    PROFILE_PAIR_CANCEL("INFO001/051", object : TypeToken<INFO001_051_Rs>() {}), // 基本資料mts取消
//    GET_PROFILE_RESULT("INFO001/060", object : TypeToken<INFO001_060_Rs>() {}), // 基本資料結果頁清單
//    LOAD_PROFILE_LIST("INFO001/010", object : TypeToken<INFO001_010_Rs>() {}), // 取得基本資料清單
//    LOAD_PROFILE_OPTION_LIST("INFO001/info", object : TypeToken<INFO001_info_Rs>() {}), // 取得基本資料選單
//    TRANSLATION_ADDRESS_TO_ENGLISH("INFO001/eaddr", object : TypeToken<INFO001_eaddr_Rs>() {}), // 地址中翻英
//
//    // deposit withdraw
//    DEPOSIT_ACCOUNT_LIST("TWDW001/010", object : TypeToken<TWDW001_010_Rs>() {}), // 現金提存 - 取得用戶帳號清單
//    DEPOSIT_ACCOUNT("TWDW001/020", object : TypeToken<TWDW001_020_Rs>() {}), // 現金提存 - 取得存款手填用戶帳號
//    DEPOSIT_EDIT("TWDW001/021", object : TypeToken<TWDW001_021_Rs>() {}), // 現金提存 - 新增/編輯/移除單筆填單
//    DEPOSIT_SUBMIT("TWDW001/030", object : TypeToken<TWDW001_030_Rs>() {}), // 現金提存 - 提交填單
//    DEPOSIT_CONFIRM_RETURN("TWDW001/accountInfo", object : TypeToken<TWDW001_accountInfo_Rs>() {}),
//    DEPOSIT_CONFIRM_TO_QUEUE("TWDW001/040", object : TypeToken<TWDW001_040_Rs>() {}),
//    DEPOSIT_QUEUE_CANCEL("TWDW001/041", object : TypeToken<TWDW001_041_Rs>() {}),
//
//    // home page
//    HOME_PAGE_STATE("HOME001/010", object : TypeToken<HOME001_010>() {}), // 取得新首頁的功能狀態列表
    ;
}
