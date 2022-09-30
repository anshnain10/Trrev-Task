package com.example.trrevtask;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataPojo {
    private int status;
    private String message;
    private List<Pojo2> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Pojo2> getData() {
        return data;
    }

    public void setData(List<Pojo2> data) {
        this.data = data;
    }
}
