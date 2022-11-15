package com.example.parking_lot.manager

import com.example.parking_lot.api.ApiState
import com.example.parking_lot.model.base.HandShakeWBResponse
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume

/**
 * Created by Ricky on 5/11/21.<br/>
 * responsible for handshake send/resend api<br/>
 * and interfacing after flow
 *
 */
object HandShakeManager {
    var handshake: HandShakeWBResponse? = null

    const val HEADER_X_AUTH_TOKEN = "x-auth-token"
//    suspend fun handshake() = suspendCoroutine { cont ->
//        try {
//            val response = APIService.handshake()
//            val xAuthToken = response.headers()[HEADER_X_AUTH_TOKEN]
//            if (response.isSuccessful) {
//                response.body()?.rsData?.let { resp ->
//                    normalFlow(resp, xAuthToken)
//                    cont.resume(ApiState.SUCCESS)
//                } ?: kotlin.run {
//                    failFlow(cont)
//                }
//            } else {
//                failFlow(cont)
//            }
//        } catch (ex: Exception) {
//            LogUtils.d(Log.getStackTraceString(ex))
//            failFlow(cont)
//        }
//    }

    private fun normalFlow(response: HandShakeWBResponse, xAuthToken: String?) {
        handshake = response
        xAuthToken?.let {
            handshake?.lastXAuthToken = it
        }
    }

    private fun failFlow(cont: Continuation<ApiState>) {
        cont.resume(ApiState.FAIL)
    }
}