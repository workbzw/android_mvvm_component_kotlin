package com.work.app

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.work.module_base_standard.util.Utils

/**
 * @author bzw [workbzw@outlook.com]
 * @date   2021/11/28 11:46 下午
 * @desc   [ 主Application]
 */
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Utils.initAppContext(this)
        initARouter()
    }

    private fun initARouter() {
        if (BuildConfig.DEBUG) {           // These two lines must be written before init, otherwise these configurations will be invalid in the init process
            ARouter.openLog();     // Print log
            ARouter.openDebug();   // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug mode! Online version needs to be closed, otherwise there is a security risk)
        }
        ARouter.init(this);
    }
}