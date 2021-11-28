package com.work.module_base_standard.base.activity

import androidx.databinding.ViewDataBinding
import com.work.module_base_standard.base.BaseViewModel

/**
 * @author bzw [workbzw@outlook.com]
 * @date   2021/11/28 11:18 下午
 * @desc   []
 */
abstract class BaseActivity<DB : ViewDataBinding, VM : BaseViewModel> : BaseMVVMActivity<DB, VM>() {
}