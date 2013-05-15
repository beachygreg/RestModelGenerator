package com.test.accounts;

import java.util.Date;


public class Account {

    private Integer id;
    private String name;
    private Date time;


    public Integer getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public Date getTime(){
        return this.time;
    }


    public void setId(Integer id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setTime(Date time){
        this.time = time;
    }


}