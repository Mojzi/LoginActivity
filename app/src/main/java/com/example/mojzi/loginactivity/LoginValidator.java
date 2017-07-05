package com.example.mojzi.loginactivity;

import android.util.Log;

import com.example.mojzi.loginactivity.users.User;
import com.example.mojzi.loginactivity.users.UsersDAO;
import com.example.mojzi.loginactivity.users.UsersDaoImpl;

/**
 * Created by mojzi on 04.07.17.
 * Checks if login and password typed by user are correct
 */

class LoginValidator {
    private UsersDAO users = new UsersDaoImpl();

    public void fillSampleData() {
        users.insertUser(new User("Admin", "Admin1"));
    }

    public boolean loginCorrect(String login, String password) {
        if(login == null || password == null || users.getAllUsers() == null) {
            return false;
        }
        for(User user : users.getAllUsers()) {
            if(login.equals(user.getLogin()) && password.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
