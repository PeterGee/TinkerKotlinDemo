package com.gee.peter.myapplication.download

/**
 *  Created by geqipeng
 *  date : 2019/4/22
 *  desc :下载接口
 */
interface IDownLoadCallBack{
    fun onDownloadSuccess()
    fun onDownloadFailed(msg:String,code:Int)
    fun onProgress(progress:Float)
}