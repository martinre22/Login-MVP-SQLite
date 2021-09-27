package com.example.loginmvp.Login.repository;

import com.example.loginmvp.pojo.User;

public interface ILoginRepository {
    User getUser();
    boolean isUser(User user);
}
