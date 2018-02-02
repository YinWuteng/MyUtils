package yinwuteng.com.myutils.md;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;



import java.util.ArrayList;

import yinwuteng.com.myutils.R;

/**
 * Created by yinwuteng on 2018/2/2.
 * 底部导航栏
 */

public class BottomActivity extends AppCompatActivity {
    private ViewPager mViewPage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_bar);
        initView();
    }

    private void initView() {
        final BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        mViewPage.setCurrentItem(0);
                        break;
                    case R.id.book:
                        mViewPage.setCurrentItem(1);
                        break;
                    case R.id.heart:
                        mViewPage.setCurrentItem(2);
                        break;
                    case R.id.setting:
                        mViewPage.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });

        mViewPage = findViewById(R.id.viewPage);

        final ArrayList<Fragment> fgLists = new ArrayList<>();
        fgLists.add(new FragmentVoice());
        fgLists.add(new FragmentBook());
        fgLists.add(new FragmentHeart());
        fgLists.add(new FragmentSetting());
        //设置适配器用于封装fragment
        FragmentPagerAdapter mPageAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fgLists.get(position);
            }

            @Override
            public int getCount() {
                return fgLists.size();
            }
        };
        //设置适配器
        mViewPage.setAdapter(mPageAdapter);
        //预加载剩余3页
        mViewPage.setOffscreenPageLimit(3);
        //viewPage监听器
        mViewPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
