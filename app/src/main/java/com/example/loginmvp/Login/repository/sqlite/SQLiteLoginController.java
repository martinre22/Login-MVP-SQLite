package com.example.loginmvp.Login.repository.sqlite;

import android.content.Context;

import com.example.loginmvp.Login.repository.ILoginRepository;
import com.example.loginmvp.pojo.User;
import com.example.loginmvp.repository.sqlite.gestordb.ISQLiteControllerUser;
import com.example.loginmvp.repository.sqlite.sqliteControllerEntities.SQLiteControllerUser;

public class SQLiteLoginController implements ILoginRepository {

    private ISQLiteControllerUser controllerUser;

    public SQLiteLoginController(Context context) {
        this.controllerUser = new SQLiteControllerUser(context);
    }

    @Override
    public User getUser() {
        return controllerUser.getUser();
    }


    @Override
    public boolean isUser(User user) {
        if(controllerUser.existsUser(user))
            return true;
        return false;
    }
}
