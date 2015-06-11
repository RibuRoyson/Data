package com.imrokraft.databasesimple;

/**
 * Created by imrokraft on 4/6/15.
 */
public class details {
    String name, qual;
    int id;

    details(int id, String name, String qual) {
        this.id = id;
        this.name = name;
        this.qual = qual;
    }
    details( String name, String qual) {
        this.id = -1;
        this.name = name;
        this.qual = qual;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQual() {
        return qual;
    }

    public void setQual(String qual) {
        this.qual = qual;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
