package yinwuteng.com.myutils.permissiondemo;


import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import yinwuteng.com.myutils.R;


/**
 * Created by yinwuteng on 2018/1/28.
 * 权限activity
 */

public class PermissionActivity extends Activity {
    private static final String TAG = "PermissionActivity";
    private static final int CAMERA_OPEN = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_main);
        Button btnCamera = findViewById(R.id.button_camera);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT > 22) {
                    cameraPermissionIsOpen();
                } else {
//这个说明系统版本在6.0之下，不需要动态获取权限。
                }

            }
        });
    }

    private void cameraPermissionIsOpen() {
        int selfPermission = ContextCompat.checkSelfPermission(PermissionActivity.this, Manifest.permission.CAMERA);
        if (selfPermission != PackageManager.PERMISSION_GRANTED) {
            /**
             * 判断该权限请求是否已经被 Denied(拒绝)过。  返回：true 说明被拒绝过 ; false 说明没有拒绝过
             *
             * 注意：
             * 如果用户在过去拒绝了权限请求，并在权限请求系统对话框中选择了 Don't ask again 选项，此方法将返回 false。
             * 如果设备规范禁止应用具有该权限，此方法也会返回 false。
             */
            if (ActivityCompat.shouldShowRequestPermissionRationale(PermissionActivity.this, Manifest.permission.CAMERA)) {
                Log.d(TAG, "该权限已经被拒绝了");


                new AlertDialog.Builder(PermissionActivity.this).setTitle("提醒").setMessage("是否需要开启照相机权限").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //开启照相机权限
                        ActivityCompat.requestPermissions(PermissionActivity.this, new String[]{android.Manifest.permission.CAMERA}, CAMERA_OPEN);
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(PermissionActivity.this, "你取消了开启照相机权限", Toast.LENGTH_SHORT).show();
                    }
                }).create().show();

            } else {
                Log.d(TAG, "该权限未被拒绝过");
                ActivityCompat.requestPermissions(PermissionActivity.this, new String[]{Manifest.permission_group.CAMERA}, CAMERA_OPEN);
            }
        } else {
            //open 照相机
            Log.d(TAG, "open camera");
            Toast.makeText(PermissionActivity.this, "你开启了照相机权限", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case CAMERA_OPEN:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //打开相机
                    //openCamera();
                } else {
                    Toast.makeText(PermissionActivity.this, "你拒绝了开启照相机权限", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }
}

