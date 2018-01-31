package yinwuteng.com.myutils.md;

import android.graphics.drawable.Drawable;

/**
 * Created by yinwuteng on 2018/1/31.
 * 数据体
 */

public class MdBean {
    private String name;
    private int imageId;

    public MdBean(String s, int drawable) {
        this.name = s;
        this.imageId = drawable;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }


}
