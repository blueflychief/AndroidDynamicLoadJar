package com.infinite.dynamicloadjar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

/**
 * Email: 690797861@qq.com
 * Author: Infinite
 * Date: 2019-11-23 - 18:39
 * Description: Class description
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
            finish();
            return;
        }
    }

    public boolean permissionsCheck(String[] permissions) {
        if (permissions == null || permissions.length == 0) {
            return true;
        }
        boolean allGranted = true;
        for (String neededPermission : permissions) {
            allGranted &= ContextCompat.checkSelfPermission(this, neededPermission)
                    == PackageManager.PERMISSION_GRANTED;
        }
        return allGranted;
    }


    public void permissionRequest(Activity activity, String[] permissions, int requestCode) {
        ActivityCompat.requestPermissions(activity,
                permissions, requestCode);
    }

    public boolean permissionsGranted(int[] grantResults) {
        boolean allGranted = true;
        for (int grantResult : grantResults) {
            allGranted &= (grantResult == PackageManager.PERMISSION_GRANTED);
        }
        return allGranted;
    }


    public void showToast(final String message) {
        if (!TextUtils.isEmpty(message)) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(BaseActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            });

        }
    }


    public void hideKeyboard(View tokenView) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(tokenView.getWindowToken(), 0); //强制隐藏键盘
        }
    }
}
