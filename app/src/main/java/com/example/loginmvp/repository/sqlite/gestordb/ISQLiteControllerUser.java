package com.example.loginmvp.repository.sqlite.gestordb;

import com.example.loginmvp.pojo.User;

public interface ISQLiteControllerUser {
    boolean registerUser(User user);
    boolean existsUser(User user);
    User getUser();
}
