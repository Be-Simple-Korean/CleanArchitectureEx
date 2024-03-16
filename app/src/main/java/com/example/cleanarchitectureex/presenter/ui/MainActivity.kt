package com.example.cleanarchitectureex.presenter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.cleanarchitectureex.R
import com.example.cleanarchitectureex.databinding.ActivityMainBinding
import com.example.cleanarchitectureex.presenter.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

//    private val adapter by lazy { MainAdapter() }
    private val viewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        ).apply {
            view = this@MainActivity
        }
        viewModel.requestRepositories()

    }
}