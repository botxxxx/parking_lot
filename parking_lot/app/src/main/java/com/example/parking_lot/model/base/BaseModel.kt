package com.example.parking_lot.model.base

import com.example.parking_lot.utils.GsonUtils
import java.io.Serializable

/**
 * Created by Ricky on 4/8/21.
 */
open class BaseModel : Serializable {
    override fun toString(): String {
        return GsonUtils.getGson().toJson(this)
    }
}