package yinwuteng.com.myutils;

import okhttp3.Call;

/**
 * Created by yinwuteng on 2018/1/25.
 * 获取消息监听通用接口
 */

public interface OnMainListener {
    void success(String response);

    void failed(Call call);
}
