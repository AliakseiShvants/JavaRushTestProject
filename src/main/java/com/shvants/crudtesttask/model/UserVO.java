package com.shvants.crudtesttask.model;
import java.util.Date;

/**
 * Created by Shvantc.ao on 12.07.2016.
 */
public class UserVO {

    private int id ;
    private String name;
    private int age;
    private boolean isAdmin;
    private Date createdDate;

    public UserVO() {}

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

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
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
        return "".concat("UserVO [id=").concat(String.valueOf(getId())).concat(", name=").concat(getName()).concat(", age=").concat(String.valueOf(getAge())).concat(", is admin=").concat(isAdmin() ? "yes" : "no").concat(String.valueOf(getCreatedDate())).concat("]");
    }
}
