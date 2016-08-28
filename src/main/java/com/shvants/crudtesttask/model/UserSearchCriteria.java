package com.shvants.crudtesttask.model;

public class UserSearchCriteria extends PageCriteria{

    private String name;
    private int age;
    private Boolean isAdmin;

    public UserSearchCriteria() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

}
