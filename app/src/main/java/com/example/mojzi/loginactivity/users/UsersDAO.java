package com.example.mojzi.loginactivity.users;

import java.util.LinkedList;

/**
 * Created by mojzi on 04.07.17.
 *  DataArrayObject interface
 */

public interface UsersDAO {

    LinkedList<User> getAllUsers();
    User getUser(String login);

    boolean insertUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(User user);
}
