package com.infinite.dynamicloadjar;

import android.util.Log;

/**
 * Email: 690797861@qq.com
 * Author: Infinite
 * Date: 2020/6/5 - 17:48
 * Description: Class description
 */
public class Utils {
    //此方法将会在loadJar1.jar中被调用
    public static void fitPlugin(String message) {
        String result = "Utils fit plugin :" + message;
        Log.e("tag", result);
    }
}
