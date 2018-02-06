package yinwuteng.com.myutils.expandview.dto;

import com.warmtel.expandtab.KeyValueBean;

import java.util.List;

/**
 * Created by yinwuteng on 2018/2/6.
 * 地区配置
 */

public class ConfigAreaDTO extends BaseDTO {
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<KeyValueBean> getBusinessCircle() {
        return businessCircle;
    }

    public void setBusinessCircle(List<KeyValueBean> businessCircle) {
        this.businessCircle = businessCircle;
    }

    private String key;
    private String value;
    private List<KeyValueBean> businessCircle;

}
