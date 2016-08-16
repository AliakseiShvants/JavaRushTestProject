package com.shvants.crudtesttask.model;

public class UserCriteria {

    private String name;
    private String age;
    private String admin;

    public UserCriteria(String name, String age, String admin) {
        this.name = name;
        this.age = age;
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }
}
