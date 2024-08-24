package com.harkhark.core.ui

import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity(){
    private var eventConfirmedTime: Long = 0

    companion object {
        private val TAG = BaseActivity::class.java.simpleName
    }

    @RequiresApi(Build.VERSION_CODES.HONEYCOMB)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING)
    }

    override fun onResume() {
        super.onResume()
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
    }
}
