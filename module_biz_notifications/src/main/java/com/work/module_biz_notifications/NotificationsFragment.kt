package com.work.module_biz_notifications

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.work.module_base_custom.RouterPath
import com.work.module_base_standard.base.fragment.BaseFragment
import com.work.module_base_standard.util.toast
import com.work.module_biz_notifications.databinding.NotificationFragmentHomeBinding

@Route(path = RouterPath.NOTIFICATION.HOME)
class NotificationsFragment :
    BaseFragment<NotificationFragmentHomeBinding, NotificationsViewModel>() {
    override fun setLayoutId(): Int = R.layout.notification_fragment_home

    override fun init(savedInstanceState: Bundle?) {
        clickBtnNotification()
        requestData()//请求数据
        responseData()//返回数据
    }

    private fun clickBtnNotification() {
        binding.textNotifications.setOnClickListener {
            "textNotifications.click()".toast()
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