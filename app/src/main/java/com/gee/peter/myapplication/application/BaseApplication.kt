package com.gee.peter.myapplication.application

import android.annotation.TargetApi
import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.multidex.MultiDex
import android.util.Log
import com.gee.peter.myapplication.util.TinkerLogImp
import com.gee.peter.myapplication.util.TinkerApplicationContext
import com.gee.peter.myapplication.util.TinkerManager
import com.tencent.tinker.entry.DefaultApplicationLike
import com.tencent.tinker.lib.tinker.Tinker
import com.tencent.tinker.lib.tinker.TinkerInstaller

/**
 *  Created by geqipeng
 *  date : 2019/4/19
 *  desc : baseApplication类
 */

open class BaseApplication: DefaultApplicationLike{
    constructor(application:Application,
                tinkerFlags:Int,
                tinkerLoadVerifyFlag:Boolean,
                applicationStartElapsedTime:Long,
                applicationStartMillisTime:Long,
                tinkerResultIntent:Intent): super(
        application,
        tinkerFlags,
        tinkerLoadVerifyFlag,
        applicationStartElapsedTime,
        applicationStartMillisTime,
        tinkerResultIntent
    )

    override fun onBaseContextAttached(base: Context?) {
        super.onBaseContextAttached(base)
        //you must install multiDex whatever tinker is installed!
        MultiDex.install(base)

        TinkerApplicationContext.application = application
        TinkerApplicationContext.context = application
        TinkerManager.setTinkerApplicationLike(this)

        TinkerManager.initFastCrashProtect()
        //should set before tinker is installed
        TinkerManager.setUpgradeRetryEnable(true)

        //optional set logIml, or you can use default debug log
        TinkerInstaller.setLogIml(TinkerLogImp())

        //installTinker after load multiDex
        //or you can put com.tencent.tinker.** to main dex

    }

    override fun onCreate() {
        super.onCreate()
        Log.d("peter","installTinker")
        TinkerManager.installTinker(this)
        val tinker = Tinker.with(application)
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    fun registerActivityLifecycleCallbacks(callback: Application.ActivityLifecycleCallbacks) {
        application.registerActivityLifecycleCallbacks(callback)
    }
}