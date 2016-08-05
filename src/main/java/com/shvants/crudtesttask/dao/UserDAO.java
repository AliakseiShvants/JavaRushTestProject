package com.shvants.crudtesttask.dao;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by aliaksei on 3.8.16.
 */
@Entity
@Table(name  = "User")
public class UserDAO {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(name = "name", length = 25)
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "isAdmin")
    private boolean isAdmin;
    @Column(name= "createdDate")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate;

    public UserDAO() {}

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
        return "".concat("User [id=").concat(String.valueOf(getId())).concat(", name=").concat(getName()).concat(", age=").concat(String.valueOf(getAge())).concat(", is admin=").concat(isAdmin() ? "yes" : "no").concat(String.valueOf(getCreatedDate())).concat("]");
    }

    public void getUsers(){}
}
