package yinwuteng.com.myutils.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import yinwuteng.com.myutils.R;
import yinwuteng.com.myutils.databinding.ActivityMvvmRecycleBinding;

/**
 * Create By ywt
 * 2019/2/13.
 */
public class RecyclerActivity extends AppCompatActivity {
    private ActivityMvvmRecycleBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm_recycle);
        initRecyclerView();
    }

    private void initRecyclerView() {
        //设置recycler
        LinearLayoutManager manager = new LinearLayoutManager(RecyclerActivity.this);
        binding.recycler.setLayoutManager(manager);
        //初始化适配器
        SwordsmanAdapter adapter = new SwordsmanAdapter(getList());
        //设置适配器
        binding.recycler.setAdapter(adapter);
    }

    private List<Swordsman> getList() {
        List<Swordsman> list = new ArrayList<>();
        Swordsman swordsman1 = new Swordsman("杨影枫", "SS");
        Swordsman swordsman2 = new Swordsman("月眉儿", "A");
        list.add(swordsman1);
        list.add(swordsman2);
        return list;
    }
}
