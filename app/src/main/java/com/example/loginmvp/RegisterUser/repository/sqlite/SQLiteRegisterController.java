package com.example.loginmvp.RegisterUser.repository.sqlite;

import android.content.Context;

import com.example.loginmvp.RegisterUser.repository.IRegisterRepository;
import com.example.loginmvp.pojo.User;
import com.example.loginmvp.repository.sqlite.gestordb.ISQLiteControllerUser;
import com.example.loginmvp.repository.sqlite.sqliteControllerEntities.SQLiteControllerUser;

public class SQLiteRegisterController implements IRegisterRepository {

    private ISQLiteControllerUser controllerUser;

    public SQLiteRegisterController(Context context) {
        this.controllerUser = new SQLiteControllerUser(context);
    }

    @Override
    public boolean registerUser(User user) {
        if (controllerUser.registerUser(user))
            return true;
        return false;
    }
}
