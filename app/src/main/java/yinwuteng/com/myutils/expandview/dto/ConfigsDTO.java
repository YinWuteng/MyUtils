package yinwuteng.com.myutils.expandview.dto;

import com.warmtel.expandtab.KeyValueBean;

import java.util.List;

/**
 * Created by yinwuteng on 2018/2/6.
 * 所有配置
 */

public class ConfigsDTO extends BaseDTO {
    public List<ConfigAreaDTO> getCantonAndCircle() {
        return cantonAndCircle;
    }

    public void setCantonAndCircle(List<ConfigAreaDTO> cantonAndCircle) {
        this.cantonAndCircle = cantonAndCircle;
    }

    public List<KeyValueBean> getDecorType() {
        return decorType;
    }

    public void setDecorType(List<KeyValueBean> decorType) {
        this.decorType = decorType;
    }

    public List<KeyValueBean> getMangerType() {
        return mangerType;
    }

    public void setMangerType(List<KeyValueBean> mangerType) {
        this.mangerType = mangerType;
    }

    public List<KeyValueBean> getOpenDataType() {
        return openDataType;
    }

    public void setOpenDataType(List<KeyValueBean> openDataType) {
        this.openDataType = openDataType;
    }

    public List<KeyValueBean> getPriceType() {
        return priceType;
    }

    public void setPriceType(List<KeyValueBean> priceType) {
        this.priceType = priceType;
    }

    public List<KeyValueBean> getSortType() {
        return sortType;
    }

    public void setSortType(List<KeyValueBean> sortType) {
        this.sortType = sortType;
    }

    private List<ConfigAreaDTO> cantonAndCircle;
    private List<KeyValueBean> decorType;
    private List<KeyValueBean> mangerType;
    private List<KeyValueBean> openDataType;
    private List<KeyValueBean> priceType;
    private List<KeyValueBean> sortType;
}
