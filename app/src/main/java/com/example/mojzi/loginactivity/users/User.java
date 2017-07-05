package com.example.mojzi.loginactivity.users;

/**
 * Created by mojzi on 04.07.17.
 * Simple User Class
 */

public class User {

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String login;
    private String password;
}
