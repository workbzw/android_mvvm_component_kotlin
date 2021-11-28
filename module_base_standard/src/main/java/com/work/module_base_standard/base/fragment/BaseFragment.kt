package com.work.module_base_standard.base.fragment

import androidx.databinding.ViewDataBinding
import com.work.module_base_standard.BaseViewModel

/**
 * @author bzw [workbzw@outlook.com]
 * @date   2021/11/28 11:55 下午
 * @desc   []
 */
abstract class BaseFragment<DB : ViewDataBinding, VM : BaseViewModel> : BaseMVVMFragment<DB, VM>() {
}