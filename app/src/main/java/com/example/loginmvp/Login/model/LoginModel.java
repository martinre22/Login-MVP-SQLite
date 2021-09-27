package com.example.loginmvp.Login.model;

import android.content.Context;

import com.example.loginmvp.Login.MVPLoginUser;
import com.example.loginmvp.Login.repository.ILoginRepository;
import com.example.loginmvp.Login.repository.sqlite.SQLiteLoginController;
import com.example.loginmvp.pojo.User;

public class LoginModel implements MVPLoginUser.Model {

    private ILoginRepository iLoginRepository;

    public LoginModel(Context context)
    {
        this.iLoginRepository = new SQLiteLoginController(context);
    }


    @Override
    public boolean existsUser(String firstName, String lastName) {
        User obUser = new User(firstName, lastName);
        boolean register = iLoginRepository.isUser(obUser);
        if (register)
            return true;
        return false;
    }

    @Override
    public String getUserNameUserLogged() {
        User user = iLoginRepository.getUser();
        String username = user.getUsername();
        return username;
    }


}
