package com.example.imrokraft.frag;

/**
 * Created by imrokraft on 24/3/15.
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }
}
