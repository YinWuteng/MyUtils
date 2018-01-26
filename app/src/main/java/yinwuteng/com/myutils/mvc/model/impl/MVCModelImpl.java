package yinwuteng.com.myutils.mvc.model.impl;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import yinwuteng.com.myutils.OnMainListener;
import yinwuteng.com.myutils.mvc.model.MVCModel;

/**
 * Created by yinwuteng on 2018/1/26.
 * 网络请求实现
 */

public class MVCModelImpl implements MVCModel {
    @Override
    public void getUrl(String url, final OnMainListener listener) {
        OkHttpUtils.get().url(url).tag(this).build().execute(new StringCallback() {
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
