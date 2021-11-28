package com.work.module_base_standard.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.work.module_base_standard.BR
import com.work.module_base_standard.base.BaseViewModel
import java.lang.reflect.ParameterizedType

/**
 * @author bzw [workbzw@outlook.com]
 * @date   2021/11/28 11:52 下午
 * @desc   []
 */
abstract class BaseMVVMFragment<DB : ViewDataBinding, VM : BaseViewModel> : AbstractBaseFragment() {
    lateinit var binding: DB
    lateinit var viewModel: VM

    abstract fun setLayoutId(): Int
    abstract fun init(savedInstanceState: Bundle?)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initViewModel()
        initDataBinding(inflater, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(savedInstanceState)
    }

    private fun initDataBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) {
        binding = DataBindingUtil.inflate(
            inflater,
            setLayoutId(),
            container,
            false
        )
        binding.lifecycleOwner = this
        binding.setVariable(BR.vm, viewModel)
        binding.executePendingBindings()
    }

    private fun initViewModel() {
        val modelClass: Class<*>
        val type = javaClass.genericSuperclass
        modelClass = if (type is ParameterizedType) {
            type.actualTypeArguments[1] as Class<*>
        } else {
            BaseViewModel::class.java
        }
        viewModel = ViewModelProvider(this).get(modelClass as Class<VM>)
    }
}