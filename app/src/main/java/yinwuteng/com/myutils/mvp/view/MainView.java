package yinwuteng.com.myutils.mvp.view;


import yinwuteng.com.myutils.mvp.bean.MainBean;

/**
 * Created by yinwuteng on 2018/1/25.
 * 主页上面定义的主要方法
 */

public interface MainView {
    String getName();

    String getPassword();

    String getUrl();

    void showFailError();

    void userGetMain(MainBean bean);
}
