package com.shvants.crudtesttask.service;

import com.shvants.crudtesttask.exception.UserNotFoundException;
import com.shvants.crudtesttask.model.User;
import com.shvants.crudtesttask.model.UserSearchCriteria;

import java.util.List;

public interface UserService {

    //poluchaem vsech pol'zovatelej iz bazy
    List<User> getAllUsers();

    //dobavljaem novogo pol'zovatelja
    void add(User user);

    //udaljaem pol'zovatelja
    void delete(int id) throws UserNotFoundException;

    // vozvrashchaet pol'zovatelja dlja redaktirovanija
    User getUser(int id);

    // obnovljem informaziju o pol'zovatele
    void update(User user) throws UserNotFoundException;

    // poisk pol'zovatelja (servis poisk)
    List<User> searchUsers(UserSearchCriteria user);

    // chislo pol'zovatelej (dlja pejdzinga)
    Integer countUsers(UserSearchCriteria userSearchCriteria);
}
