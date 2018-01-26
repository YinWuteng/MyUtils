package yinwuteng.com.myutils.mvp.model.impl;


import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import yinwuteng.com.myutils.OnMainListener;
import yinwuteng.com.myutils.mvp.model.MainBeanModel;

/**
 * Created by yinwuteng on 2018/1/25.
 * 首页获取实现
 */

public class MainModelImple implements MainBeanModel {
    //模拟测试登录
    @Override
    public void login(String userName, String password, String url, final OnMainListener listener) {
        OkHttpUtils.get()
                .url(url)
                .addParams("name", userName)
                .addParams("password", password)
                .tag(this)
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                listener.failed(call);
            }

            @Override
            public void onResponse(String response, int id) {
                listener.success(response);

            }
        });
    }
}
