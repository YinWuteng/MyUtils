package yinwuteng.com.myutils.expandview.dto;

import java.io.Serializable;

/**
 * Created by yinwuteng on 2018/2/6.
 * 基础摹本
 */

public class BaseDTO implements Serializable {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String id;
    private String name;
}
