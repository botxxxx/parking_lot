package com.example.parking_lot.login

import com.example.parking_lot.model.base.BaseViewInterface

/**
 * Created by Ricky on 4/16/21.<br/>
 * this is login MVP contract<br/>
 * in here you can find presenter and view
 */
interface LoginContract {

    interface Presenter {
        fun doLogin(name: String, pwd: String)
    }

    interface View : BaseViewInterface {
        fun goHomePage()
        fun onError()
    }
}

// enum class LoginErrorStatus(val errorType: String)