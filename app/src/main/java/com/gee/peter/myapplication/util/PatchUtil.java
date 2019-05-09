package com.gee.peter.myapplication.util;


import java.io.IOException;
import java.io.InputStream;

/**
 * Created by geqipeng
 * date : 2019/4/24
 * desc : 补丁工具类
 */
public class PatchUtil {
    public static Integer getPatchVersion(){
        try {
            InputStream inputStream= TinkerApplicationContext.context.getAssets().open("patchVersion.txt");
            int size=inputStream.available();
            byte[] bytes=new byte[size];
            inputStream.read(bytes);
            inputStream.close();
            String str=new String(bytes);
            return Integer.parseInt(str.split("=")[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
