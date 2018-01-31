package yinwuteng.com.myutils.md;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import yinwuteng.com.myutils.R;

/**
 * Created by yinwuteng on 2018/1/31.
 * Material Design
 */

public class MDActivity extends AppCompatActivity {
    private MdBean[] mdBeans = {new MdBean("1", R.mipmap.ic_lancher), new MdBean("2", R.mipmap.ic_lancher), new MdBean("3", R.mipmap.ic_lancher), new MdBean("4", R.mipmap.ic_lancher), new MdBean("5", R.mipmap.ic_lancher), new MdBean("6", R.mipmap.ic_lancher), new MdBean("7", R.mipmap.ic_lancher), new MdBean("8", R.mipmap.ic_lancher), new MdBean("9", R.mipmap.ic_lancher), new MdBean("10", R.mipmap.ic_lancher), new MdBean("11", R.mipmap.ic_lancher), new MdBean("12", R.mipmap.ic_lancher), new MdBean("13", R.mipmap.ic_lancher), new MdBean("14", R.mipmap.ic_lancher), new MdBean("15", R.mipmap.ic_lancher), new MdBean("16", R.mipmap.ic_lancher), new MdBean("17", R.mipmap.ic_lancher), new MdBean("18", R.mipmap.ic_lancher), new MdBean("19", R.mipmap.ic_lancher), new MdBean("20", R.mipmap.ic_lancher), new MdBean("21", R.mipmap.ic_lancher), new MdBean("22", R.mipmap.ic_lancher), new MdBean("23", R.mipmap.ic_lancher), new MdBean("24", R.mipmap.ic_lancher), new MdBean("25", R.mipmap.ic_lancher), new MdBean("26", R.mipmap.ic_lancher),};
    private List<MdBean> mdBeanList = new ArrayList<>();
    private SwipeRefreshLayout swipeLayout;
    private MDAdapter adapter;

    public MDActivity() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_md);
        initList();
        initView();
    }

    private void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        swipeLayout = findViewById(R.id.swipe_refresh);
        swipeLayout.setColorSchemeResources(R.color.colorAccent);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //下拉刷新加载
                refreshBean();
            }
        });
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MDAdapter(MDActivity.this, mdBeanList);
        recyclerView.setAdapter(adapter);

    }

    private void initList() {
        mdBeanList.clear();
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            int index = random.nextInt(mdBeans.length);
            mdBeanList.add(mdBeans[index]);
        }
    }

    private void refreshBean() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initList();
                        adapter.notifyDataSetChanged();
                        swipeLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }
}
