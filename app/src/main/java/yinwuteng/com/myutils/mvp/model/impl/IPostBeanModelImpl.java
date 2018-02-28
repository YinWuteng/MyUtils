package yinwuteng.com.myutils.mvp.model.impl;

import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import okhttp3.MediaType;
import yinwuteng.com.myutils.OnMainListener;
import yinwuteng.com.myutils.mvp.bean.PostBean;
import yinwuteng.com.myutils.mvp.model.IPostBeanModel;

/**
 * Created by yinwuteng on 2018/1/25.
 * 上传数据实现
 */

public class IPostBeanModelImpl implements IPostBeanModel {
    @Override
    public void postModel(String name, String password, String url, final OnMainListener listener) {
        PostBean bean = new PostBean();
        bean.setUserName(name);
        bean.setPassword(password);
        OkHttpUtils.postString()
                .url(url).content(JSON.toJSONString(bean))
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .tag(this)
                .build()
                .execute(new StringCallback() {
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
