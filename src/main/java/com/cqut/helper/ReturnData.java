package com.cqut.helper;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName
 *
 * @author qiaowei.wu
 * @version 1.0 2015/12/10 12:17
 */
public class ReturnData {
    private int status = 0;

    private Object data;

    private String message;

    public ReturnData(int status) {
        this.status = status;
    }

    public ReturnData(String message) {
        this.message = message;
    }

    public ReturnData(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ReturnData put(String key, Object value) {
        if (data == null) {
            data = new HashMap<String, Object>();
        }
        ((Map<String, Object>) data).put(key, value);

        return this;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
