package yinwuteng.com.myutils.okhttpandmvp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zhy.http.okhttp.OkHttpUtils;

import yinwuteng.com.myutils.R;
import yinwuteng.com.myutils.okhttpandmvp.view.MainView;
import yinwuteng.com.myutils.okhttpandmvp.bean.MainBean;
import yinwuteng.com.myutils.okhttpandmvp.present.MainPresent;

public class MainActivity extends Activity implements MainView {
    private MainPresent present = new MainPresent(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取内容
                present.doGet();
            }
        });
        Button button1 = findViewById(R.id.btn_post);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //上传内容
                present.doPost();
            }
        });

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
