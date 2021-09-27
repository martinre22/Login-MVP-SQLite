package com.example.loginmvp.RegisterUser.model;

import android.content.Context;

import com.example.loginmvp.RegisterUser.MVPRegisterUser;
import com.example.loginmvp.RegisterUser.repository.IRegisterRepository;
import com.example.loginmvp.RegisterUser.repository.sqlite.SQLiteRegisterController;
import com.example.loginmvp.pojo.User;
import com.example.loginmvp.repository.sqlite.gestordb.ISQLiteControllerUser;
import com.example.loginmvp.repository.sqlite.sqliteControllerEntities.SQLiteControllerUser;

public class RegisterUserModel implements MVPRegisterUser.Model {

    private Context context;
    private IRegisterRepository iRegisterRepository;

    public RegisterUserModel(Context context) {
        this.context = context;
        this.iRegisterRepository = new SQLiteRegisterController(context);
    }

    @Override
    public boolean registerUser(String userName, String password) {
        User obUser = new User(userName, password);
        boolean register = iRegisterRepository.registerUser(obUser);
        if (register)
            return true;
        return false;
    }
}
