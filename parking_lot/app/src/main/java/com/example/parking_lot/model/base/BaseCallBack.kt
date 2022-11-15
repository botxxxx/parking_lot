package com.example.parking_lot.model.base

import android.util.Log
import android.view.View
import com.example.parking_lot.api.ApiEventType
import com.example.parking_lot.manager.HandShakeManager
import com.example.parking_lot.utils.DialogUtils
import com.example.parking_lot.utils.Loading
import com.example.parking_lot.utils.LogUtils
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response

/**
 * Created by Ricky on 2021/9/7.<br/>
 * this is base call back use for network library use
 */
abstract class BaseCallBack<T, T2>(private val eventType: ApiEventType, private val baseViewInterface: BaseViewInterface) {
    fun getEventTypePath() = eventType.path

    companion object {
        private const val KEY_STATUS_BO = "statusBo"
    }

    fun getResponse(response: Response<T>) {
//        val xAuthToken = response.headers()[HandShakeManager.HEADER_X_AUTH_TOKEN]
//        xAuthTokenFlow(xAuthToken)
        if (response.isSuccessful) {
            normalFlow(response)
        } else {
            errorFlow(response)
        }
    }

    private fun normalFlow(response: Response<T>) {
        try {
            if (!response.isDBSResponse()) {
                outNormalFlow(response)
                return
            }

//            val decryptData = decryptFlow(response)
//            if (decryptData.isEmpty()) {
//                onFailure(dataToStatusBo(response, RuntimeException(StatusBo.COMMON_DESC_ERROR)))
//                return
//            }

//            val dataToObj = dataToObject(decryptData)
//            if (dataToObj == null) {
//                onFailure(dataToStatusBo(response, RuntimeException(StatusBo.COMMON_DESC_ERROR)))
//                return
//            }

//            if (decryptData.hasStatusBO()) {
//                dataToStatusBo(decryptData)?.let {
//                    if (!it.isSuccess) {
//                        onFailure(it)
//                        return
//                    }
//
//                    (dataToObj as BaseModel).statusBo = it
//                }
//            }

//            GlobalScope.launch(Dispatchers.Main) {
//                onResponse(dataToObj)
//            }
        } catch (ex: Exception) {
            LogUtils.e("DBSCallback normalFlow fail: ${Log.getStackTraceString(ex)}")
            errorFlow(response)
        }
    }

    private fun outNormalFlow(response: Response<T>) {
        GlobalScope.launch(Dispatchers.Main) {
            val statusBo = dataToStatusBo(response, RuntimeException(StatusBo.COMMON_DESC_ERROR))
            if (response.hasDBSErrorData()) {
                val errorData = (response.body() as DBSResponse).errorData
                if (statusBo.hasValidateMap()) {
                    statusBo.validateMap = errorData?.errorFields
                    onFailure(statusBo)
                } else {
                    onFailureAlertFlow(errorData, statusBo)
                }
            } else {
                onFailure(statusBo)
            }
        }
    }

//    private fun dataToStatusBo(decryptData: String): StatusBo? {
//        val response = Gson().fromJson(decryptData, COMMON01_010_Rs::class.java)
//        return response.statusBo
//    }

    fun errorFlow(response: Response<T>?) {
        GlobalScope.launch(Dispatchers.Main) {
            onFailure(dataToStatusBo(response, RuntimeException(StatusBo.COMMON_DESC_ERROR)))
        }
    }

//    private fun decryptFlow(response: Response<T>): String {
//        val encodeData = (response.body() as DBSResponse).rsData
//        val aesKey = HandShakeManager.handshake?.sessionKey
//        val ivKey = HandShakeManager.handshake?.sessionIV
//        return AESEncryptUtilKt.decrypt(encodeData, aesKey, ivKey)
//    }

    private fun dataToObject(data: String): T2 {
        return Gson().fromJson(data, eventType.tokenType.type)
    }

    private fun xAuthTokenFlow(xAuthToken: String?) {
        xAuthToken?.let {
            HandShakeManager.handshake?.lastXAuthToken = it
        }
    }

    private fun dataToStatusBo(response: Response<T>? = null, throwable: Throwable? = null): StatusBo {
        val body = response?.body()
            ?: return StatusBo.getCommonErrorStatusBO()

        return StatusBo().apply {
            (body as DBSResponse).let {
                systemId = it.systemId
                statusDesc = it.statusDesc
                txTime = it.clientTime
                messageCode = it.messageCode
                statusCode = it.statusCode
            }

            throwable?.let {
                exception = it
                exceptionMessage = Log.getStackTraceString(it)
            }

            errorCode = StatusBo.COMMON_ERROR_CODE_ERROR
        }
    }

    private fun String?.hasStatusBO(): Boolean {
        if (isNullOrEmpty()) {
            return false
        }

        try {
            if (contains(KEY_STATUS_BO)) {
                return true
            }

            return false
        } catch (ex: Exception) {
            LogUtils.d("body as Response fail:${Log.getStackTraceString(ex)}")
            return false
        }
    }

    private fun Response<T>.hasDBSErrorData(): Boolean {
        if (body() == null) {
            return false
        }

        try {
            if ((body() as DBSResponse).errorData == null) {
                return false
            }

            return true
        } catch (ex: Exception) {
            LogUtils.d("body as Response fail:${Log.getStackTraceString(ex)}")
            return false
        }

    }

    private fun Response<T>.isDBSResponse(): Boolean {
        if (body() == null) {
            return false
        }

        try {
            if ((body() as DBSResponse).rsData.isNullOrEmpty()) {
                return false
            }

            return true
        } catch (ex: Exception) {
            LogUtils.d("body as Response fail:${Log.getStackTraceString(ex)}")
            return false
        }

    }

    private fun onFailureAlertFlow(errorData: RsErrorData?, statusBo: StatusBo) {
        baseViewInterface?.getContext()?.run {
            Loading.hide()

            val title = errorData?.content?.title ?: ""

            val desc = if (errorData?.iconType == ERROR_ICON_TYPE.ExclamationMark.value) {
                errorData.content.subtitle + "\n" + "[${statusBo.systemId}-${statusBo.messageCode}]"
            } else {
                errorData?.content?.subtitle ?: ""
            }
//            val iconRes = if (errorData?.iconType == ERROR_ICON_TYPE.ExclamationMark.value) {
//                R.drawable.ic_dialogs_error_new
//            } else {
//                R.drawable.ic_dialogs_bell
//            }

            val leftBtnText = errorData?.leftButton?.text
            val rightBtnText = errorData?.rightButton?.text
            DialogUtils.showNormalAlert(
                this,
//                iconRes = iconRes,
                title = title,
                msg = desc,
                rightButtonText = rightBtnText,
                rightButtonListener = getOnAlertClickListener(
                    desc,
                    statusBo.statusCode,
                    eventType,
                    BtnPosition.RIGHT_BUTTON,
                    baseViewInterface,
                    errorData?.rightButton?.action
                ),
                leftButtonText = leftBtnText,
                leftButtonListener = getOnAlertClickListener(
                    desc,
                    statusBo.statusCode,
                    eventType,
                    BtnPosition.LEFT_BUTTON,
                    baseViewInterface,
                    errorData?.leftButton?.action
                ),
            )
//            try {
//                callBackToPresenter?.invoke(errorData, statusBo, eventType)
//            } catch (throwable: Throwable) {
//                LogUtils.d("callBackToPresenter fail: %s", Log.getStackTraceString(throwable))
//            }
        }
    }

    enum class BtnPosition {
        LEFT_BUTTON, RIGHT_BUTTON;
    }

    open fun getOnAlertClickListener(
        desc: String,
        statusCode: String?,
        eventType: ApiEventType,
        btnPos: BtnPosition,
        baseViewInterface: BaseViewInterface?,
        alertActionValue: String?
    ): View.OnClickListener? {
        return null
    }

    abstract fun onResponse(response: T2)
    abstract fun onFailure(statusBo: StatusBo)
}