package yinwuteng.com.myutils.mvvm;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import yinwuteng.com.myutils.R;

import com.moon.ActivityFirst;

/**
 * Create By ywt
 * 2019/1/31.
 */
public class MVVMActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //等价于setContentView()
        ActivityFirst binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        //给布局中的控件赋值
        Swordsman swordsman = new Swordsman("张无忌", "S");
        binding.setSwordsman(swordsman);

        click(binding);
    }

    private void click(ActivityFirst binding) {
        binding.setOnClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_1:
                        Toast.makeText(MVVMActivity.this, "button1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.btn_2:
                        Toast.makeText(MVVMActivity.this, "button2", Toast.LENGTH_SHORT).show();

                        break;
                }
            }
        });
        binding.setName("风清扬");
        binding.setAge(30);
        binding.setMan(true);

        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        binding.setList(list);
        Map<String, String> map = new HashMap<>();
        map.put("age", "30");
        binding.setMap(map);

        String[] arrays = {"张无忌", "慕容龙城"};
        binding.setArrays(arrays);

    }

}
