package yinwuteng.com.myutils.okhttpandmvp.view;


import yinwuteng.com.myutils.okhttpandmvp.bean.MainBean;

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
