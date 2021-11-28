package com.work.module_biz_dashboard

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.work.module_base_custom.RouterPath
import com.work.module_base_standard.base.fragment.BaseFragment
import com.work.module_base_standard.util.toast
import com.work.module_biz_dashboard.databinding.DashboardFragmentHomeBinding

@Route(path = RouterPath.DASHBOARD.HOME)
class DashboardFragment : BaseFragment<DashboardFragmentHomeBinding, DashboardViewModel>() {
    override fun setLayoutId(): Int = R.layout.dashboard_fragment_home

    override fun init(savedInstanceState: Bundle?) {
        clickBtnDashboard()
        requestData()//请求数据
        responseData()//返回数据
    }

    private fun clickBtnDashboard() {
        binding.textDashboard.setOnClickListener {
            "clickBtnDashboard.click()".toast()
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