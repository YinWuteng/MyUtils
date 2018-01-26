package yinwuteng.com.myutils.mvp.model;

import yinwuteng.com.myutils.OnMainListener;

/**
 * Created by yinwuteng on 2018/1/25.
 * 主页数据模型接口
 */

public interface MainBeanModel {
    /**
     * 获取数据模块操作接口
     */
    void login(String userName, String password, String url,OnMainListener listener);
}
