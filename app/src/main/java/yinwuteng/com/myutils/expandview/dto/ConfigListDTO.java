package yinwuteng.com.myutils.expandview.dto;

import com.warmtel.expandtab.KeyValueBean;

import java.util.List;

/**
 * Created by yinwuteng on 2018/2/6.
 * 配置list
 */

public class ConfigListDTO extends BaseDTO {
    public List<KeyValueBean> getInfo() {
        return info;
    }

    public void setInfo(List<KeyValueBean> info) {
        this.info = info;
    }

    private List<KeyValueBean> info;
}
