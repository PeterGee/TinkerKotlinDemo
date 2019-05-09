package com.gee.peter.myapplication.download


/**
 *  Created by geqipeng
 *  date : 2019/4/22
 *  desc : 文件下载
 */
class DownloadUtil{
  /*  fun dowload(dowloadUrl: String, outPath: String, mHandler: Handler?, callback:IDownLoadCallBack) {
        val request = Request.Builder().url(dowloadUrl).build()
        val call = OkHttpClient.Builder().readTimeout(60 * 5, TimeUnit.SECONDS).build().newCall(request)
        call.enqueue(object : Callback() {
            fun onFailure(call: Call, e: IOException) {
                callback!!.onFailure(call, e)
            }

            @Throws(IOException::class)
            fun onResponse(call: Call, response: Response) {
                if (!response.isSuccessful()) {
                    if (callback != null) {
                        callback!!.onResponse(call, response)
                    }
                    return
                }
                val `is` = response.body().byteStream()
                val length = response.body().contentLength()
                val file = File(outPath)
                val fos = FileOutputStream(file)
                var len = 0
                val buf = ByteArray(1024)
                var l: Long = 0
                val format = NumberFormat.getPercentInstance()// 获取格式化类实例
                while ((len = `is`.read(buf)) != -1) {
                    l += len.toLong()
                    fos.write(buf, 0, len)
                    if (null != mHandler) {
                        format.minimumFractionDigits = 0// 设置小数位
                        val msg = Message()
                        msg.what = HandlerConstant1.DOWNLOAD_PRORESS
                        msg.obj = format.format((l.toFloat() / length.toFloat()).toDouble())
                        mHandler.sendMessage(msg)
                    }
                }
                fos.flush()
                `is`.close()
                if (callback != null) {
                    callback!!.onResponse(call, response)
                }
            }

        })
    }*/


}