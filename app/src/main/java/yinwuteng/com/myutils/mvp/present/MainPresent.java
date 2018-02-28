package yinwuteng.com.myutils.mvp.present;

import com.alibaba.fastjson.JSON;


import okhttp3.Call;
import yinwuteng.com.myutils.mvp.view.MainView;
import yinwuteng.com.myutils.mvp.bean.MainBean;
import yinwuteng.com.myutils.mvp.model.IMainBeanModel;
import yinwuteng.com.myutils.mvp.model.impl.MainModelImple;
import yinwuteng.com.myutils.OnMainListener;
import yinwuteng.com.myutils.mvp.model.IPostBeanModel;
import yinwuteng.com.myutils.mvp.model.impl.IPostBeanModelImpl;

/**
 * Created by yinwuteng on 2018/1/25.
 * 首页控制器
 */

public class MainPresent {
    private IMainBeanModel IMainBeanModel;
    private MainView mainView;
    private IPostBeanModel IPostBeanModel;
    public MainPresent(MainView mainView) {
        this.IMainBeanModel = new MainModelImple();
        this.mainView = mainView;
        this.IPostBeanModel =new IPostBeanModelImpl();
    }

    /**
     * 测试获取数据
     */
    public void doGet() {
        IMainBeanModel.login(mainView.getName(), mainView.getPassword(), mainView.getUrl(), new OnMainListener() {
            @Override
            public void success(String response) {
                MainBean bean = JSON.parseObject(response, MainBean.class);
                mainView.userGetMain(bean);
            }

            @Override
            public void failed(Call call) {
                mainView.showFailError();
            }
        });
    }
    /**
     * 测试上传数据
     */
    public void doPost(){
     IPostBeanModel.postModel(mainView.getName(), mainView.getPassword(), mainView.getUrl(), new OnMainListener() {
         @Override
         public void success(String response) {

         }

         @Override
         public void failed(Call call) {

         }
     });
    }

}
