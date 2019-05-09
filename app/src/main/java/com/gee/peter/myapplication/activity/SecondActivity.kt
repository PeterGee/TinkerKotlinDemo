package com.gee.peter.myapplication.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.gee.peter.myapplication.R
import com.gee.peter.myapplication.util.PatchUtil

/**
 *  Created by geqipeng
 *  date : 2019/4/24
 *  desc :
 */
class SecondActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sercond)
       val versionCode=packageManager.getPackageInfo(packageName,0).versionCode
        val patchVersion=PatchUtil.getPatchVersion()

        Toast.makeText(this,"patchVersion is $patchVersion",Toast.LENGTH_LONG).show()
    }
}