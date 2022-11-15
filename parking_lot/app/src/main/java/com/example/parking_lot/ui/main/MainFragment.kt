package com.example.parking_lot.ui.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.parking_lot.R
import com.example.parking_lot.login.LoginContract
import com.example.parking_lot.login.LoginPresenter
import kotlinx.coroutines.CoroutineScope

class MainFragment : Fragment(), LoginContract.View {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val presenter = LoginPresenter(this)

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.doLogin("hw001@noodoe.com","homework")
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun goHomePage() {
        Log.e("test", "goHome")
    }

    override fun onError() {
        Log.e("test", "onError")
    }

    override fun getContext(): Context = context

    override fun getLifeCycleScope(): CoroutineScope = getLifeCycleScope()
}