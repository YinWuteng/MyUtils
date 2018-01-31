package yinwuteng.com.myutils.md;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import yinwuteng.com.myutils.R;

/**
 * Created by yinwuteng on 2018/1/31.
 * 详情
 */

public class MdDetailActivity extends AppCompatActivity {
    public static final String NAME = "name";
    public static final String IMAGE_ID = "imageId";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_md_detail);
        Intent intent = getIntent();
        String name = intent.getStringExtra(NAME);
        int imageId = intent.getIntExtra(IMAGE_ID, 0);
        Toolbar toolbar = findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        ImageView image = findViewById(R.id.image_view);
        TextView textView = findViewById(R.id.tv_content);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setTitle(name);
//        Glide.with(this).load(imageId).into(image);
        String content = generate(name);
        textView.setText(content);
    }

    private String generate(String name) {
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < 5000; i++) {
            content.append(name);
        }
        return content.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
