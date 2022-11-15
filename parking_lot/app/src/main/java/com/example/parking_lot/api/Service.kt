package com.example.parking_lot.api

import com.example.parking_lot.model.base.BaseModel
import com.example.parking_lot.model.base.DBSResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

/**
 * Created by Ricky on 4/7/21.<br/>
 * this is dbs service retrofit api interface
 */
interface Service {
    @Headers("Accept: */*", "Content-Type: application/json;charset=UTF-8")
    @POST("login")
    suspend fun sendRequest(
        @Header("x-parse-application-id") appId: String? = "vqYuKPOkLQLYHhk4QTGsGKFwATT4mBIGREI2m8eD",
        @Body request: BaseModel
    ): Response<DBSResponse>
}