package com.example.loginmvp.RegisterUser;

public interface MVPRegisterUser {

    interface View{
        String getUserName();
        String getPassword();
        String getPasswordRepeat();

        void showErrorUserNameEmptyField();
        void showErrorPasswordEmptyField();
        void showErrorPasswordRepeatEmptyField();
        void showErrorRegisterUser();
        void showErrorPasswordsNoMatch();

        void showMsgSuccesfullyOperation();

    }
    interface Presenter{
        void registerUserButtonClicked();
    }
    interface Model{
        boolean registerUser(String userName, String password);
    }
}
