package com.gee.peter.myapplication.activity

import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import com.gee.peter.myapplication.R
import com.gee.peter.myapplication.util.PatchUtil
import com.gee.peter.myapplication.util.TinkerUtils
import com.tencent.tinker.lib.tinker.Tinker
import com.tencent.tinker.lib.tinker.TinkerInstaller
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals


class MainActivity : AppCompatActivity(), View.OnClickListener {
    val TAG= "peter"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        Log.d("peter","PatchUtil.getPatchVersion() => "+PatchUtil.getPatchVersion())
        val btnLoadPatch = findViewById<Button>(R.id.loadPatch)
        btnLoadPatch.setOnClickListener(this)
        val btnCleanPatch = findViewById<Button>(R.id.cleanPatch)
        btnCleanPatch.setOnClickListener(this)
        val btnKillSelf = findViewById<Button>(R.id.killSelf)
        btnKillSelf.setOnClickListener(this)
        val btnJump=findViewById<Button>(R.id.btn_jump)
        btnJump.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.loadPatch -> {
                Log.d(TAG,"loadPatch")
                TinkerInstaller.onReceiveUpgradePatch(
                    applicationContext,
                    Environment.getExternalStorageDirectory().absolutePath + "/patch_signed_7zip.apk"
                )
            }
            R.id.cleanPatch -> {
                Log.d(TAG,"cleanPatch")
                Tinker.with(applicationContext).cleanPatch()
            }
            R.id.killSelf -> {
                Log.d(TAG,"killSelf")
                ShareTinkerInternals.killAllOtherProcess(applicationContext)
                android.os.Process.killProcess(android.os.Process.myPid())
            }
            R.id.btn_jump -> {
                Log.d(TAG,"jumpToSecondActivity")
                startActivity(Intent(this,SecondActivity::class.java))
            }
        }
    }

    override fun onResume() {
        super.onResume()
        TinkerUtils.setBackground(false)

    }

    override fun onPause() {
        super.onPause()
        TinkerUtils.setBackground(true)
    }

}
