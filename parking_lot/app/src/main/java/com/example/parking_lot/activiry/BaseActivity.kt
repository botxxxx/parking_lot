package com.example.parking_lot.activiry

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity

/**
 * Created by Ricky on 2021/9/8.<br/>
 * adjust status bar
 */
open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addSecureFlags()
    }

    /**
     * @see android.view.Display.FLAG_SECURE
     * treat the content of the window as secure, preventing it from appearing in screenshots or from being viewed on non-secure displays.
     */
    private fun Activity.addSecureFlags() {
        window.addFlags(WindowManager.LayoutParams.FLAG_SECURE)
    }
}