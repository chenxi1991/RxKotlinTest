package com.example.a39092.rxjavatest.model.bean;

/**
 * Created by 39092 on 2017/4/1.
 */

public class StatusData<T> {
    private int status;
    private String info;
    private T data;

    public StatusData(int status, String info) {
        this.status = status;
        this.info = info;
    }

    public StatusData(int status, String info, T data) {
        this.status = status;
        this.info = info;
        this.data = data;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
