package com.infinite.dynamicloadjar;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.infinite.dynamicloadjar.bean.CountryWrap;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

//import com.infinite.dynamicloadjar.plugin.CountryBean;

public class MainActivity extends BaseActivity {
    private static final String[] PERMISSION_LIST = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };


    private static String COUNTRY_JSON = "{\"name\":\"China\",\"provinceBeanList\":[{\"code\":0,\"name\":\"province 0\"},{\"code\":1,\"name\":\"province 1\"},{\"code\":2,\"name\":\"province 2\"},{\"code\":3,\"name\":\"province 3\"}]}";

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tvResult);
        findViewById(R.id.btLoad).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                CountryWrap countryWrap = CountryBean.parseBean(COUNTRY_JSON);
//                Log.d("tag", "countryWrap is:\n" + countryWrap);

                //获取DexClassLoader
                String jarPath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "amap/loadJar1.jar";
                DexClassLoader classLoader = PluginLoader.getClassLoader(jarPath, MainActivity.this);

                //运行PluginLoader
                loadPluginLoader(classLoader);

                //运行CountryBean
                loadCountryBean(classLoader);
            }
        });

        if (!permissionsCheck(PERMISSION_LIST)) {
            permissionRequest(this, PERMISSION_LIST, 10);
        }
    }

    private void loadPluginLoader(DexClassLoader classLoader) {
        Class<?> pluginLoaderClass = null;
        try {
            pluginLoaderClass = classLoader.loadClass("com.infinite.dynamicloadjar.plugin.PluginLoader");
            //调用对象的方法
            Constructor<?> pluginLoaderConstructor = pluginLoaderClass.getConstructor(new Class[]{});
            Object pluginLoaderObj = pluginLoaderConstructor.newInstance(new Object[]{});
            Method loadMethod = pluginLoaderClass.getDeclaredMethod("loadMethod", String.class);
            loadMethod.setAccessible(true);
            String returnResult = (String) loadMethod.invoke(pluginLoaderObj, "World");
            Toast.makeText(MainActivity.this, returnResult, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadCountryBean(DexClassLoader classLoader) {
        Class<?> countryBeanClass = null;
        try {
            countryBeanClass = classLoader.loadClass("com.infinite.dynamicloadjar.plugin.CountryBean");
            //调用类的静态方法
            Method parseBeanMethod = countryBeanClass.getDeclaredMethod("parseBean", String.class);
            //调用类的静态方法，所以第一个参数传null
            CountryWrap countryWrap = (CountryWrap) parseBeanMethod.invoke(null, COUNTRY_JSON);
            if (countryWrap != null) {
                tvResult.setText(countryWrap.toString());
            } else {
                tvResult.setText("null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 10) {
            if (permissionsGranted(grantResults)) {

            }
        }
    }
}