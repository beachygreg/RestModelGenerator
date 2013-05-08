package com.test.model;

import java.util.List;import com.test.account.Account;

public class Company {

    private Integer id;
    private String name;
    private List<Account> accounts;


    public Integer getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public List<Account> getAccounts(){
        return this.accounts;
    }


    public void setId(Integer id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAccounts(List<Account> accounts){
        this.accounts = accounts;
    }


}