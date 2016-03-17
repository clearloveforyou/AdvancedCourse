package com.hsl.android.qianfeng.advancedcourse.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by clearlove on 2016/2/27.
 */
public class TitleEntity implements Serializable {

    private List<DataEntity> data;
    private String errorMessage;

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
