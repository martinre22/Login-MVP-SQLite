package com.example.loginmvp.RegisterUser.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.loginmvp.R;
import com.example.loginmvp.RegisterUser.MVPRegisterUser;
import com.example.loginmvp.RegisterUser.presenter.RegisterUserPresenter;
import com.example.loginmvp.databinding.ActivityRegisterUserViewBinding;

public class RegisterUserView extends AppCompatActivity implements MVPRegisterUser.View, View.OnClickListener {

    private ActivityRegisterUserViewBinding registerUserViewBinding;
    private MVPRegisterUser.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_register_user_view);
        registerUserViewBinding = ActivityRegisterUserViewBinding.inflate(getLayoutInflater());
        android.view.View view = registerUserViewBinding.getRoot();
        setContentView(view);

        presenter = new RegisterUserPresenter(this, this);

        registerUserViewBinding.buttonLogin.setOnClickListener(this);
    }

    @Override
    public String getUserName() {

        return registerUserViewBinding.editTextUsername.getText().toString();
    }

    @Override
    public String getPassword() {

        return registerUserViewBinding.editTextPassword.getText().toString();
    }

    @Override
    public String getPasswordRepeat() {

        return registerUserViewBinding.editTextRepeatPassword.getText().toString();
    }

    @Override
    public void showErrorUserNameEmptyField() {
        registerUserViewBinding.editTextUsername.setError("Campo Obligatorio");
    }

    @Override
    public void showErrorPasswordEmptyField() {
        registerUserViewBinding.editTextPassword.setError("Campo Obligatorio");
    }

    @Override
    public void showErrorPasswordRepeatEmptyField() {
        registerUserViewBinding.editTextRepeatPassword.setError("Campo Obligatorio");
    }

    @Override
    public void showErrorRegisterUser() {
        Toast.makeText(this, "Error registro usuario", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showErrorPasswordsNoMatch() {
        Toast.makeText(this, "Las contraseñas ingresadas no coinciden", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMsgSuccesfullyOperation() {
        Toast.makeText(this, "Usuario registrado con exito", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button_login:
                presenter.registerUserButtonClicked();
                break;
        }
    }
}