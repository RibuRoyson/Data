package com.example.imrokraft.customizedlistview;

import java.util.ArrayList;

/**
 * Created by imrokraft on 10/3/15.
 */
public class UserModel {
    String name="";
    String email="";
    public UserModel(String name,String email)
    {
        this.name=name;
        this.email=email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
