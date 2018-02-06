package yinwuteng.com.myutils.expandview.dto;

/**
 * Created by yinwuteng on 2018/2/6.
 * 消息配置
 */

public class ConfigsMessageDTO {
    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }

    public ConfigsDTO getInfo() {
        return info;
    }

    public void setInfo(ConfigsDTO info) {
        this.info = info;
    }

    private String resultCode;
    private String resultInfo;
    private ConfigsDTO info;
}
