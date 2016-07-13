package main.java.com.shvants.crudtesttask.model;

import javafx.scene.input.DataFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Shvantc.ao on 12.07.2016.
 */
public class User {
    private int currentId = 0;
    private int id ;
    private String name;
    private int age;
    private boolean isAdmin;
    private Date createdDate;

    public User(String name, int age, boolean isAdmin) {
        this.id = currentId++;
        this.name = name;
        this.age = age;
        this.isAdmin = isAdmin;
        this.createdDate = new Date();
    }
}
