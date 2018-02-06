package yinwuteng.com.myutils.expandview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.alibaba.fastjson.JSONObject;
import com.warmtel.expandtab.ExpandPopTabView;
import com.warmtel.expandtab.KeyValueBean;
import com.warmtel.expandtab.PopOneListView;
import com.warmtel.expandtab.PopTwoListView;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import yinwuteng.com.myutils.R;
import yinwuteng.com.myutils.expandview.dto.ConfigAreaDTO;
import yinwuteng.com.myutils.expandview.dto.ConfigsDTO;
import yinwuteng.com.myutils.expandview.dto.ConfigsMessageDTO;

/**
 * Created by yinwuteng on 2018/2/6.
 * 仿美团二级联动
 */

public class ExpandPopTabActivity extends AppCompatActivity {
    private static final String TAG = "ExpandPopTabActivity";
    private ExpandPopTabView expandPopTabView;
    private List<KeyValueBean> mParentsLists = new ArrayList<>();
    private List<ArrayList<KeyValueBean>> mChildrenListLists = new ArrayList<>();
    private List<KeyValueBean> mPriceLists;
    private List<KeyValueBean> mSortLists;
    private List<KeyValueBean> mFavorLists;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_view);
        setConfigsDates();
        expandPopTabView = findViewById(R.id.expandtab_view);
        addItem(expandPopTabView, mPriceLists, "", "价格");
        addItem(expandPopTabView, mFavorLists, "默认", "排序");
        addItem(expandPopTabView, mSortLists, "优惠最多", "优惠");
        addItems(expandPopTabView, mParentsLists, mChildrenListLists, "锦江区", "合江亭", "区域");
    }

    private void addItem(ExpandPopTabView expandPopTabView, List<KeyValueBean> lists, String defaultSelect, String defaultShowTest) {
        PopOneListView popOneListView = new PopOneListView(this);
        popOneListView.setDefaultSelectByValue(defaultSelect);
        popOneListView.setCallBackAndData(lists, expandPopTabView, new PopOneListView.OnSelectListener() {
            @Override
            public void getValue(String key, String value) {
                Log.d(TAG, key + " " + value);
            }
        });
        expandPopTabView.addItemToExpandTab(defaultShowTest, popOneListView);
    }

    private void addItems(ExpandPopTabView expandPopTabView, List<KeyValueBean> parentLists, List<ArrayList<KeyValueBean>> childrenLists, String defaultParentSelect, String defaultChildSelect, String defaultShowText) {
        PopTwoListView popTwoListView = new PopTwoListView(this);
        popTwoListView.setDefaultSelectByValue(defaultParentSelect, defaultChildSelect);
        popTwoListView.setCallBackAndData(expandPopTabView, parentLists, childrenLists, new PopTwoListView.OnSelectListener() {
            @Override
            public void getValue(String showText, String parentKey, String childrenKey) {
                Log.d(TAG, parentKey + " " + childrenKey);
            }
        });
        expandPopTabView.addItemToExpandTab(defaultShowText, popTwoListView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (expandPopTabView != null) {
            expandPopTabView.onExpandPopView();
        }
    }

    private void setConfigsDates() {
        try {
            InputStream is = getAssets().open("searchType");
            String searchTypeJson = readStream(is);
            ConfigsMessageDTO messageDTO = JSONObject.parseObject(searchTypeJson, ConfigsMessageDTO.class);
            ConfigsDTO configsDTO = messageDTO.getInfo();

            mPriceLists = configsDTO.getPriceType();
            mSortLists = configsDTO.getSortType();
            mFavorLists = configsDTO.getSortType();

            List<ConfigAreaDTO> configAreaDTOList = configsDTO.getCantonAndCircle();
            for (ConfigAreaDTO configAreaDTO : configAreaDTOList) {
                KeyValueBean keyValueBean = new KeyValueBean();
                keyValueBean.setKey(configAreaDTO.getKey());
                keyValueBean.setValue(configAreaDTO.getValue());
                mParentsLists.add(keyValueBean);
                ArrayList<KeyValueBean> childrenLists = new ArrayList<>();
                for (KeyValueBean keyValueBean1 : configAreaDTO.getBusinessCircle()) {
                    childrenLists.add(keyValueBean1);
                }
                mChildrenListLists.add(childrenLists);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readStream(InputStream is) {
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            int i = is.read();
            while (i != -1) {
                bo.write(i);
                i = is.read();
            }
            return bo.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
