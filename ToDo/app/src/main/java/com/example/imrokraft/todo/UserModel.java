package com.example.imrokraft.todo;

/**
 * Created by imrokraft on 23/3/15.
 */
public class UserModel {
    String name="";
    String dates="";
    String data="";
    public UserModel(String name, String dates, String data) {
        this.name=name;
        this.dates=dates;
        this.data=data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
