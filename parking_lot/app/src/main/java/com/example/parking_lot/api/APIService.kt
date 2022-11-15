package com.example.parking_lot.api

import com.example.parking_lot.manager.NetworkManager
import com.example.parking_lot.model.base.BaseCallBack
import com.example.parking_lot.model.base.BaseModel
import com.example.parking_lot.model.base.DBSResponse
import com.example.parking_lot.model.base.Request
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

/**
 * Created by Ricky on 4/7/21.<br/>
 * this is api manager<br/>
 * call this object to request/response api
 */
object APIService {
    private fun getRequest(txnUID: String? = null): Request {
        if (!txnUID.isNullOrEmpty()) {
//            lastTxnUID = txnUID
        }
        return Request(
            trackingId = UUID.randomUUID().toString(),
//            txnUid = lastTxnUID,
//            uuid = DeviceConfig.androidId,
//            model = DeviceUtils.getDeviceName(),
//            appVersion = NetworkAppUtils.versionName,
//            version = DeviceUtils.getOsVersion()
        )
    }

    fun <RS : BaseModel> sendAppRequest(callback: BaseCallBack<DBSResponse, RS>, rqData: BaseModel?) {
        GlobalScope.launch {
            try {
                val rq = getRequest()
                rqData?.let {
//                    val dataJSON = Gson().toJson(it)
//                    val data = dataJSON.toByteArray()
//                    val wbKey = HandShakeManager.handshake?.wbSessionKey
//                    val wbIV = HandShakeManager.handshake?.wbSessionIV
//                    LogUtils.d("rq data source:${dataJSON}")
//                    val encryptData = WhiteBoxUtils.encSessionData(callback.baseViewInterface?.getContext(), data, wbKey, wbIV)
//                    rq.rqData = AESEncryptUtilKt.byteArray2HexString(encryptData)
                }
                val response = NetworkManager.service.sendRequest(request = rq)
                callback.getResponse(response)
            } catch (ex: Exception) {
                callback.errorFlow(null)
            }
        }
    }
}