package com.shvants.crudtesttask.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDAOServiceImpl implements UserDAOService{


//    private List<User> createUser(){
//        List<User> createdList = new ArrayList<User>();
//
//        User userVO0 = new User();
//        userVO0.setId(0);
//        userVO0.setName("Baushevich Anna");
//        userVO0.setAge(29);
//        userVO0.setAdmin(true);
//        userVO0.setCreatedDate(new Date());
//
//        User userVO1 = new User();
//        userVO1.setId(1);
//        userVO1.setName("Shvants Aliaksei");
//        userVO1.setAge(24);
//        userVO1.setAdmin(true);
//        userVO1.setCreatedDate(new Date());
//
//        User userVO2 = new User();
//        userVO2.setId(2);
//        userVO2.setName("Ivanov Ivan");
//        userVO2.setAge(24);
//        userVO2.setAdmin(false);
//        userVO2.setCreatedDate(new Date());
//
//        User userVO3 = new User();
//        userVO3.setId(3);
//        userVO3.setName("Ivanov Petr");
//        userVO3.setAge(20);
//        userVO3.setAdmin(false);
//        userVO3.setCreatedDate(new Date());
//
//        User userVO4 = new User();
//        userVO4.setId(4);
//        userVO4.setName("Sidorov Nikofor");
//        userVO4.setAge(21);
//        userVO4.setAdmin(false);
//        userVO4.setCreatedDate(new Date());
//
//        createdList.add(userVO0);
//        createdList.add(userVO1);
//        createdList.add(userVO2);
//        createdList.add(userVO3);
//        createdList.add(userVO4);
//
//        return createdList;
//    }
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addUser(UserDAO userDAO) {
        em.persist(userDAO);
    }

    public void updateUser(UserDAO userDAO) {

    }
    @Transactional
    public void removeUser(int id) {
        UserDAO userDAO = em.find(UserDAO.class, id);
        if (userDAO != null)
            em.remove(userDAO);
    }

    public List<UserDAO> getAllUsers() {
        return em.createQuery("from UserDAO", UserDAO.class).getResultList();
    }
}
