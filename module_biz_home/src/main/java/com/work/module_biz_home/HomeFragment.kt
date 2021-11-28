package com.work.module_biz_home

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.work.module_base_custom.RouterPath
import com.work.module_base_standard.base.fragment.BaseFragment
import com.work.module_base_standard.util.toast
import com.work.module_biz_home.databinding.HomeFragmentHomeBinding

@Route(path = RouterPath.HOME.HOME)
class HomeFragment : BaseFragment<HomeFragmentHomeBinding, HomeViewModel>() {
    override fun setLayoutId(): Int = R.layout.home_fragment_home

    override fun init(savedInstanceState: Bundle?) {
        clickBtnHome()
        requestData()//请求数据
        responseData()//返回数据
    }

    private fun clickBtnHome() {
        binding.textHome.setOnClickListener {
            "textHome.click()".toast()
        }
    }

    private fun requestData() {
        viewModel.requestData()
    }

    private fun responseData() {
        viewModel.text.observe(this) {
            it.toast()
        }
    }
}