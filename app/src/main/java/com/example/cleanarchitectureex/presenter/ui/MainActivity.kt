package com.example.cleanarchitectureex.presenter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.example.cleanarchitectureex.R
import com.example.cleanarchitectureex.databinding.ActivityMainBinding
import com.example.cleanarchitectureex.presenter.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //    private val adapter by lazy { MainAdapter() }
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )
            .apply {
                view = this@MainActivity
            }
        viewModel.requestRepositories()

        initObserve()
    }

    private fun initObserve() {
        viewModel.isLoading.observe(this) { isLoading ->
           if(isLoading){
               showProgressBar()
           }else{
               hideProgressBar()
           }
        }
    }

    private fun showProgressBar() {
        binding.pb.isVisible = true
    }

    private fun hideProgressBar() {
        binding.pb.isVisible = false
    }

    private fun showErrorDialog() {
        var dialog = AlertDialog.Builder(this).setTitle("네트워크 에러")
        dialog.show()
    }
}