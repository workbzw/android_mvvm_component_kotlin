package com.work.module_biz_notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.work.module_base_standard.BaseViewModel

class NotificationsViewModel : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text

    fun requestData() {
        _text.value = "NotificationsViewModel.requestData().请求成功"
    }
}