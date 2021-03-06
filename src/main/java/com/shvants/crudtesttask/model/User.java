package com.shvants.crudtesttask.model;
import java.util.Date;

public class User {

    private int id ;
    private String name;
    private int age;
    private Boolean isAdmin;
    private Date createdDate;

    public User() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "".concat("User [id=").concat(String.valueOf(getId())).concat(", name=").concat(getName()).concat(", age=").concat(String.valueOf(getAge())).concat(", is admin=").concat(getAdmin() ? "yes" : "no").concat(String.valueOf(getCreatedDate())).concat("]");
    }
}
