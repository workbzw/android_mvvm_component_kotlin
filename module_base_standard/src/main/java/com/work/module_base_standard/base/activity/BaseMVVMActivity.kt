package com.work.module_base_standard.base.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.work.module_base_standard.BR
import com.work.module_base_standard.base.BaseViewModel
import java.lang.reflect.ParameterizedType

/**
 * @author bzw [workbzw@outlook.com]
 * @date   2021/11/28 11:17 下午
 * @desc   []
 */
abstract class BaseMVVMActivity<DB : ViewDataBinding, VM : BaseViewModel> : AbstractBaseActivity() {
    lateinit var binding: DB
    lateinit var viewModel: VM

    abstract fun setLayoutId(): Int
    abstract fun init(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        initViewModel()
        initDataBinding()
        init(savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        initDataBinding()
        init(savedInstanceState)
    }

    private fun initViewModel() {
        /*初始化 ViewModel*/
        val modelClass: Class<*>
        val type = javaClass.genericSuperclass
        modelClass = if (type is ParameterizedType) {
            type.actualTypeArguments[1] as Class<*>
        } else {
            BaseViewModel::class.java
        }
        viewModel = ViewModelProvider(this).get(modelClass as Class<VM>)
    }

    private fun initDataBinding() {
        /*初始化 DataBinding*/
        binding = DataBindingUtil.setContentView(this, setLayoutId())
        binding.lifecycleOwner = this
        binding.setVariable(BR.vm, viewModel)
        binding.executePendingBindings()
    }
}