package com.example.parking_lot.model.error

import com.google.gson.annotations.SerializedName

/**
 * Created by Ricky on 4/8/21.
 */

data class ValidateError(
    @SerializedName("showOnGlobal")
    val showOnGlobal: Boolean,
    @SerializedName("messages")
    val messages: Map<String, String>,
    @SerializedName("errStatus")
    val errStatus: ErrStatus,
)