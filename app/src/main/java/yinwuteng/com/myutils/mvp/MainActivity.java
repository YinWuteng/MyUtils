package yinwuteng.com.myutils.mvp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zhy.http.okhttp.OkHttpUtils;

import yinwuteng.com.myutils.R;
import yinwuteng.com.myutils.mvc.MVCActivity;
import yinwuteng.com.myutils.mvp.view.MainView;
import yinwuteng.com.myutils.mvp.bean.MainBean;
import yinwuteng.com.myutils.mvp.present.MainPresent;

public class MainActivity extends Activity implements MainView, View.OnClickListener {
    private MainPresent present = new MainPresent(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //点击事件
        click();


    }

    private void click() {
        Button button = findViewById(R.id.btn);
        button.setOnClickListener(this);
        Button button1 = findViewById(R.id.btn_post);
        button1.setOnClickListener(this);
        Button btnChange = findViewById(R.id.btn_change);
        btnChange.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn:
                //获取内容
                present.doGet();
                break;
            case R.id.btn_post:
                //上传内容
                present.doPost();
                break;
            case R.id.btn_change:
                Intent intent = new Intent(MainActivity.this, MVCActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }

    }

    @Override
    public String getName() {
        return "123";
    }

    @Override
    public String getPassword() {
        return "123";
    }

    @Override
    public String getUrl() {
//        String url = "http://wanandroid.com/tools/mockapi/2008/get_code";
        String url = "http://192.168.127.22:8080/TestServlet";
        return url;
    }

    @Override
    public void showFailError() {

    }

    @Override
    public void userGetMain(MainBean bean) {
        Toast.makeText(MainActivity.this, bean.getDesc(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消请求
        OkHttpUtils.getInstance().cancelTag(this);
    }
}