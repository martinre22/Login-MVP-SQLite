package com.example.loginmvp.Login.presenter;

import android.content.Context;
import android.content.Intent;

import com.example.loginmvp.Login.MVPLoginUser;
import com.example.loginmvp.Login.model.LoginModel;
import com.example.loginmvp.RegisterUser.view.RegisterUserView;

public class LoginPresenter implements MVPLoginUser.Presenter {

    private MVPLoginUser.View view;
    private MVPLoginUser.Model model;

    public LoginPresenter(Context context, MVPLoginUser.View view)
    {
        this.view = view;
        this.model = new LoginModel(context);
    }

    @Override
    public void loginButtonClicked() {
        if (view != null)
        {
            if (view.getUserName().equals("") || view.getPassword().equals(""))
            {
                if (view.getUserName().equals(""))
                {
                    view.showUsernameEmptyField();
                }
                if (view.getPassword().equals(""))
                {
                    view.showPasswordEmptyField();
                }
            }else{
                if (model.existsUser(view.getUserName().trim(), view.getPassword().trim()))
                {
                    if (!model.getUserNameUserLogged().equals("")){
                        view.operationSuccesfull(model.getUserNameUserLogged());
                    }
                }else{
                    view.showWrongUserPassword();
                }
            }
        }
    }

    @Override
    public void linkRegisterClicked() {
        view.toActivityRegisterUser();
    }


}
