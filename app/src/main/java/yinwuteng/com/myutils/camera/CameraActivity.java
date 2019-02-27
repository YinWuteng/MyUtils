package yinwuteng.com.myutils.camera;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import yinwuteng.com.myutils.R;

/**
 * Create By ywt
 * 2019/2/27.
 */
public class CameraActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout rlCamera = findViewById(R.id.rl_camera);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.rl_camera, new CameraFragment());
        ft.commit();
    }

}
