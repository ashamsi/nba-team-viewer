package com.ashamsi.nbateamviewer

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.ashamsi.nbateamviewer.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
}
