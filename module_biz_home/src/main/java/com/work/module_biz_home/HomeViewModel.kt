package com.work.module_biz_home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.work.module_base_standard.BaseViewModel

class HomeViewModel : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    fun requestData() {
        _text.value = "HomeViewModel.requestData().请求成功"
    }
}