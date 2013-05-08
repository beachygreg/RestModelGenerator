package com.test.model;


public class User {

    private Integer id;
    private String firstName;
    private Company company;


    public Integer getId(){
        return this.id;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public Company getCompany(){
        return this.company;
    }


    public void setId(Integer id){
        this.id = id;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setCompany(Company company){
        this.company = company;
    }


}