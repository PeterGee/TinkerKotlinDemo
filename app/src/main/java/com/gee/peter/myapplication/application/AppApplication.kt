package com.gee.peter.myapplication.application

import android.app.Application
import android.content.Intent
import android.widget.Toast
import com.tencent.tinker.anno.DefaultLifeCycle
import com.tencent.tinker.loader.shareutil.ShareConstants

/**
 *  Created by geqipeng
 *  date : 2019/4/19
 *  desc : app application
 */
class AppApplication :BaseApplication{
    constructor(application: Application,
                tinkerFlags:Int,
                tinkerLoadVerifyFlag:Boolean,
                applicationStartElapsedTime:Long,
                applicationStartMillisTime:Long,
                tinkerResultIntent: Intent
    ): super(
        application,
        tinkerFlags,
        tinkerLoadVerifyFlag,
        applicationStartElapsedTime,
        applicationStartMillisTime,
        tinkerResultIntent
    )

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(application,"AppApplication",Toast.LENGTH_SHORT).show()
    }
}