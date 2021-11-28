package com.work.module_biz_dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.work.module_base_standard.base.BaseLiveData
import com.work.module_base_standard.base.BaseViewModel

class DashboardViewModel : BaseViewModel() {

    private val _text = BaseLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    fun requestData() {
        _text.value = "DashboardViewModel.requestData().请求成功"
    }
}