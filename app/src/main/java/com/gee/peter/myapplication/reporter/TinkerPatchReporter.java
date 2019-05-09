/*
 * Tencent is pleased to support the open source community by making Tinker available.
 *
 * Copyright (C) 2016 THL A29 Limited, a Tencent company. All rights reserved.
 *
 * Licensed under the BSD 3-Clause License (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 * https://opensource.org/licenses/BSD-3-Clause
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gee.peter.myapplication.reporter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.tencent.tinker.lib.reporter.DefaultPatchReporter;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;

import java.io.File;
import java.util.List;

/**
 * optional, you can just use DefaultPatchReporter
 * Created by zhangshaowen on 16/4/8.
 */
public class TinkerPatchReporter extends DefaultPatchReporter {
    private final static String TAG = "Tinker.TinkerPatchReporter";
    public TinkerPatchReporter(Context context) {
        super(context);
    }

    @Override
    public void onPatchServiceStart(Intent intent) {
        super.onPatchServiceStart(intent);
        Log.d("peter","onPatchServiceStart");
        TinkerReport.onApplyPatchServiceStart();
    }

    @Override
    public void onPatchDexOptFail(File patchFile, List<File> dexFiles, Throwable t) {
        super.onPatchDexOptFail(patchFile, dexFiles, t);
        Log.d("peter","onPatchDexOptFail");
        TinkerReport.onApplyDexOptFail(t);
    }

    @Override
    public void onPatchException(File patchFile, Throwable e) {
        super.onPatchException(patchFile, e);
        Log.d("peter","onPatchException");
        TinkerReport.onApplyCrash(e);
    }

    @Override
    public void onPatchInfoCorrupted(File patchFile, String oldVersion, String newVersion) {
        super.onPatchInfoCorrupted(patchFile, oldVersion, newVersion);
        Log.d("peter","onPatchInfoCorrupted");
        TinkerReport.onApplyInfoCorrupted();
    }

    @Override
    public void onPatchPackageCheckFail(File patchFile, int errorCode) {
        super.onPatchPackageCheckFail(patchFile, errorCode);
        Log.d("peter","onPatchPackageCheckFail  errorCode-> "+errorCode);
        TinkerReport.onApplyPackageCheckFail(errorCode);
    }

    @Override
    public void onPatchResult(File patchFile, boolean success, long cost) {
        super.onPatchResult(patchFile, success, cost);
        Log.d("peter","onPatchResult   success-> "+success +" cost -> "+cost);
        TinkerReport.onApplied(cost, success);
    }

    @Override
    public void onPatchTypeExtractFail(File patchFile, File extractTo, String filename, int fileType) {
        super.onPatchTypeExtractFail(patchFile, extractTo, filename, fileType);
        Log.d("peter","onPatchTypeExtractFail  filename->"+filename  +" fileType ->"+fileType);
        TinkerReport.onApplyExtractFail(fileType);
    }

    @Override
    public void onPatchVersionCheckFail(File patchFile, SharePatchInfo oldPatchInfo, String patchFileVersion) {
        super.onPatchVersionCheckFail(patchFile, oldPatchInfo, patchFileVersion);
        Log.d("peter","onPatchVersionCheckFail  oldPatchInfo->"+oldPatchInfo  +" patchFileVersion ->"+patchFileVersion);
        TinkerReport.onApplyVersionCheckFail();
    }
}
