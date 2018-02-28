package yinwuteng.com.myutils.mvc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;

import okhttp3.Call;
import yinwuteng.com.myutils.OnMainListener;
import yinwuteng.com.myutils.R;
import yinwuteng.com.myutils.mvc.bean.MVCBean;
import yinwuteng.com.myutils.mvc.model.IMVCModel;
import yinwuteng.com.myutils.mvc.model.impl.MVCModelImpl;

/**
 * Created by yinwuteng on 2018/1/26.
 * MVCActivity
 */

public class MVCActivity extends Activity {
    private IMVCModel IMVCModel;
    private TextView tvCode;
    private TextView tvDesc;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        initView();
        String url = "http://wanandroid.com/tools/mockapi/2008/get_code";
        displayJson(url);
    }

    private void initView() {
        tvCode = findViewById(R.id.tv_code);
        tvDesc = findViewById(R.id.tv_desc);
        IMVCModel = new MVCModelImpl();
        progressBar = findViewById(R.id.progressBar);
    }

    private void displayJson(String url) {
        progressBar.setVisibility(View.VISIBLE);
        IMVCModel.getUrl(url, new OnMainListener() {
            @Override
            public void success(String response) {
                MVCBean json = JSON.parseObject(response, MVCBean.class);
                tvCode.setText(String.valueOf(json.getCode()));
                tvDesc.setText(json.getDesc());
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void failed(Call call) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MVCActivity.this, "数据请求异常", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
