package com.miqi.springbootdemo.dto;

/**
 *  返回的统一格式
 */
public class ApiRet {
    private int ret;
    private String msg;
    private Object data;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
