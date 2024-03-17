package com.example.cleanarchitectureex.presenter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.example.cleanarchitectureex.R
import com.example.cleanarchitectureex.databinding.ActivityMainBinding
import com.example.cleanarchitectureex.presenter.adapter.MainAdapter
import com.example.cleanarchitectureex.presenter.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainAdapter by lazy { MainAdapter() }
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
                rv.adapter = mainAdapter
            }
        viewModel.requestRepositories()

        initObserve()
    }

    private fun initObserve() {
        viewModel.viewState.observe(this) { viewState ->
            when (viewState) {
                is ViewState.Loading -> {
                    showProgressBar()
                    // 로딩 상태 UI 업데이트
                }

                is ViewState.Success -> {
                    // 성공 상태 UI 업데이트
                    hideProgressBar()
                    mainAdapter.submitList(viewState.data)
                }

                is ViewState.Error -> {
                    // 에러 상태 UI 업데이트
                    hideProgressBar()
                    showErrorDialog(viewState.message)
//                    showError(viewState.message)
                }
            }
        }
        viewModel.itemList.observe(this) {
            mainAdapter.submitList(it)
        }
    }

    private fun showProgressBar() {
        binding.pb.isVisible = true
    }

    private fun hideProgressBar() {
        binding.pb.isVisible = false
    }

    private fun showErrorDialog(msg: String) {
        var dialog = AlertDialog.Builder(this)
            .setTitle("에러 발생")
            .setMessage(msg)
        dialog.show()
    }
}