package com.infinite.dynamicloadjar;

import android.content.Context;

import dalvik.system.DexClassLoader;

/**
 * Email: 690797861@qq.com
 * Author: Infinite
 * Date: 2020/6/4 - 18:02
 * Description: Class description
 */
public class PluginLoader {

    public static DexClassLoader getClassLoader(String jarFilePath, Context context) {
        String outputDir = context.getApplicationContext().getDir("dex", 0).getAbsolutePath();
        return new DexClassLoader(jarFilePath, outputDir, null, context.getClass().getClassLoader());
    }

}
