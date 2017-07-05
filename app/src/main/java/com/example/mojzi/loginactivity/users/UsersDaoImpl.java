package com.example.mojzi.loginactivity.users;

import java.util.LinkedList;

/**
 * Created by mojzi on 04.07.17.
 * Data Array Object implementation
 */

public class UsersDaoImpl implements UsersDAO {
    private LinkedList<User> users = new LinkedList<>();

    @Override
    public LinkedList<User> getAllUsers() {
        return users;
    }

    @Override
    public User getUser(String login){

        for(int i=0; i<users.size(); i++) {
            if(users.get(i).getLogin().equals(login)) {
                return users.get(0);
            }
        }
        return null;
    }

    @Override
    public boolean insertUser(User user) {
        return users.add(user);
    }

    @Override
    public boolean updateUser(User user) {
        for(int i=0; i<users.size(); i++) {
            if(users.get(i).getLogin().equals(user.getLogin())) {
                users.set(i, user);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteUser(User user) {
        return users.remove(user);
    }
}
