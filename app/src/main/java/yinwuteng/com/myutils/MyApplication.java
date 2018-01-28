package yinwuteng.com.myutils;

import android.app.Application;

import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by yinwuteng on 2018/1/25.
 * MyApplication
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //设置okhttp配置,可以设置cookie、session、证书等
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(8000, TimeUnit.MILLISECONDS)
                .readTimeout(8000, TimeUnit.MILLISECONDS)
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }
}
