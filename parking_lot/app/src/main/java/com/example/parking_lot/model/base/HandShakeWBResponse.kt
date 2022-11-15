package com.example.parking_lot.model.base

import com.google.gson.annotations.SerializedName

/**
 * Created by Ricky on 4/9/21.
 */
data class HandShakeWBResponse(
    @SerializedName("sessionKey")
    var sessionKey: String? = null,

    @SerializedName("sessionIV")
    val sessionIV: String? = null,

    @SerializedName("appKeyRed")
    val sppKeyRed: String? = null,

    @SerializedName("appKeyGreen")
    val sppKeyGreen: String? = null,

    var lastXAuthToken: String
) : BaseModel()
