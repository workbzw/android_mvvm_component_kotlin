package com.work.module_biz_notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.work.module_base_standard.base.BaseLiveData
import com.work.module_base_standard.base.BaseViewModel

class NotificationsViewModel : BaseViewModel() {

    private val _text = BaseLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text

    fun requestData() {
        _text.value = "NotificationsViewModel.requestData().请求成功"
    }
}