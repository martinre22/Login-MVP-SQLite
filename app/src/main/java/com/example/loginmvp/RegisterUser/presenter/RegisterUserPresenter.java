package com.example.loginmvp.RegisterUser.presenter;

import android.content.Context;

import com.example.loginmvp.RegisterUser.MVPRegisterUser;
import com.example.loginmvp.RegisterUser.model.RegisterUserModel;
import com.example.loginmvp.RegisterUser.view.RegisterUserView;

public class RegisterUserPresenter implements MVPRegisterUser.Presenter {
    private MVPRegisterUser.View view;
    private MVPRegisterUser.Model model;

    public RegisterUserPresenter(Context context, MVPRegisterUser.View view) {
        this.view = view;
        this.model = new RegisterUserModel(context);
    }

    @Override
    public void registerUserButtonClicked() {
        if (view != null)
        {
            if (!view.getUserName().trim().equals("") &&
            !view.getPassword().trim().equals("") &&
            !view.getPasswordRepeat().trim().equals(""))
            {
                if (view.getPassword().trim().equals(view.getPasswordRepeat()))
                {
                    if (model.registerUser(view.getUserName(), view.getPassword()))
                    {
                        view.showMsgSuccesfullyOperation();
                    }else{
                        view.showErrorRegisterUser();
                    }
                }else{
                    view.showErrorPasswordsNoMatch();
                }
            }else if (view.getUserName().trim().equals(""))
            {
                view.showErrorUserNameEmptyField();
            }else if (view.getPassword().trim().equals(""))
            {
                view.showErrorPasswordEmptyField();
            }else if (view.getPasswordRepeat().trim().equals(""))
            {
                view.showErrorPasswordRepeatEmptyField();
            }
        }
    }
}
