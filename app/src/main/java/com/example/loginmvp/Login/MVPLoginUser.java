package com.example.loginmvp.Login;

import android.content.Context;

import com.example.loginmvp.pojo.User;

public interface MVPLoginUser {
    interface View{
        void showUsernameEmptyField();
        void showPasswordEmptyField();

        void showWrongUserPassword();
        void operationSuccesfull(String username);

        void userNotExists();

        String getUserName();
        String getPassword();

        void toActivityRegisterUser();



    }
    interface Presenter{
        void loginButtonClicked();
        void linkRegisterClicked();
    }
    interface Model{

        boolean existsUser(String firstName, String lastName);
        String getUserNameUserLogged();
    }
}
