package yinwuteng.com.myutils.mvc.model;

import yinwuteng.com.myutils.OnMainListener;

/**
 * Created by yinwuteng on 2018/1/26.
 * 网络请求接口
 */

public interface MVCModel {
    void getUrl(String url, OnMainListener listener);
}
