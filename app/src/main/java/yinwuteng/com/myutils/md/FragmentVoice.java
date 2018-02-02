package yinwuteng.com.myutils.md;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yinwuteng.com.myutils.R;

/**
 * Created by yinwuteng on 2018/2/2.
 * 声音
 */

public class FragmentVoice extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom_voice, container, false);
        return view;
    }
}
