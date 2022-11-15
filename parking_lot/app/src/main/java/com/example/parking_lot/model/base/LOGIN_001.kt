package com.example.parking_lot.model.base

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by Ricky on 4/8/21.
 */
data class LOGIN_001(
    @SerializedName("username") val username: String,
    @SerializedName("password") val password: String,
) : BaseModel()