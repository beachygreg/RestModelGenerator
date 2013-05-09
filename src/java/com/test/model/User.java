package com.test.model;


public class User {

    private Integer id;
    private String firstName;
    private Company company;
    private Float weight;
    private Boolean blueEyes;


    public Integer getId(){
        return this.id;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public Company getCompany(){
        return this.company;
    }
    public Float getWeight(){
        return this.weight;
    }
    public Boolean getBlueEyes(){
        return this.blueEyes;
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
    public void setWeight(Float weight){
        this.weight = weight;
    }
    public void setBlueEyes(Boolean blueEyes){
        this.blueEyes = blueEyes;
    }


}