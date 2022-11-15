package com.example.parking_lot.login

import android.util.Log
import com.example.parking_lot.api.APIService
import com.example.parking_lot.api.ApiEventType
import com.example.parking_lot.model.base.BaseCallBack
import com.example.parking_lot.model.base.DBSResponse
import com.example.parking_lot.model.base.LOGIN_001
import com.example.parking_lot.model.base.StatusBo

/**
 * Created by Ricky on 4/16/21.
 */
class LoginPresenter(private val view: LoginContract.View) : LoginContract.Presenter {
    override fun doLogin(name: String, pwd: String) {
        APIService.sendAppRequest(object : BaseCallBack<DBSResponse, LOGIN_001>(ApiEventType.LOGIN, view) {
            override fun onResponse(response: LOGIN_001) {
                view.goHomePage()
            }

            override fun onFailure(statusBo: StatusBo) {
                Log.e("test","${statusBo.statusCode}")
                Log.e("test","${statusBo.statusDesc}")
                view.onError()
            }
        }, LOGIN_001(name, pwd))
    }
}