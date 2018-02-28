package yinwuteng.com.myutils.mvp.model;

import yinwuteng.com.myutils.OnMainListener;

/**
 * Created by yinwuteng on 2018/1/25.
 * 上传数据接口
 *
 */

public interface IPostBeanModel {
    void postModel(String name, String password, String url, OnMainListener listener);
}
