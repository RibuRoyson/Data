package com.example.imrokraft.gmail;

/**
 * Created by imrokraft on 19/3/15.
 */
public class UserModel1 {
    String name="";
    String dates="";
    String data="";
    String data2="";
    String data3="";
    public UserModel1(String names, String dates, String data, String data2, String data3) {
        this.name=names;
        this.dates=dates;
        this.data=data;
        this.data2=data2;
        this.data3=data3;
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

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public String getData3() {
        return data3;
    }

    public void setData3(String data3) {
        this.data3 = data3;
    }
}
