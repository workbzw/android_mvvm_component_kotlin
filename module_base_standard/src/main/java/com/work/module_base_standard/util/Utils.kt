package com.work.module_base_standard.util

import android.content.Context
import android.widget.Toast
import com.alibaba.android.arouter.launcher.ARouter
import com.work.module_base_standard.base.fragment.AbstractBaseFragment

/**
 * @author bzw [workbzw@outlook.com]
 * @date   2021/11/28 11:32 下午
 * @desc   []
 */
class Utils {
    companion object {
        private lateinit var context: Context

        @JvmStatic
        fun initAppContext(c: Context) {
            context = c
        }

        @JvmStatic
        fun getAppContext(): Context {
            return context
        }
    }
}

fun String.toast(dur: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(Utils.getAppContext(), this, dur).show()
}

fun appContext(): Context = Utils.getAppContext()

fun String.toActivity() {
    ARouter.getInstance().build(this).navigation()
}

fun String.findFragment(): AbstractBaseFragment {
    return ARouter.getInstance().build(this).navigation() as AbstractBaseFragment
}