package com.gee.peter.myapplication.application

import com.tencent.tinker.loader.app.TinkerApplication
import com.tencent.tinker.loader.shareutil.ShareConstants

/**
 *  Created by geqipeng
 *  date : 2019/5/9
 *  desc :
 */
open class MyBaseApplication: TinkerApplication{
    constructor(applicationName:String):
            super(
                ShareConstants.TINKER_ENABLE_ALL, applicationName,
                "com.tencent.tinker.loader.TinkerLoader", false)


}