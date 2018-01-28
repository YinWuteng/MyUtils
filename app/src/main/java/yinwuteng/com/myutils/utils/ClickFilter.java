package yinwuteng.com.myutils.utils;

/**
 * Created by yinwuteng on 2018/1/26.
 * 防止控件连续点击
 */

public class ClickFilter {
    private static long lastClickTime;

    public synchronized static boolean isFastClick() {
        long time = System.currentTimeMillis();
        //设置最小间隔时间为500ms
        if (time - lastClickTime < 500) {
            return true;
        }
        lastClickTime = time;
        return false;
    }
}
