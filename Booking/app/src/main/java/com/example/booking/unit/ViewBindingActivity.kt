package com.example.booking.unit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * this is base view binding activity<br/>
 * if want use view binding, extends this class please
 */
abstract class ViewBindingActivity<B : ViewBinding> : AppCompatActivity() {
    lateinit var binding: B
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
    }

    abstract fun getViewBinding(): B
}