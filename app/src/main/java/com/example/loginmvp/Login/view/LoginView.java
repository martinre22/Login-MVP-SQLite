package com.example.loginmvp.Login.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.loginmvp.Login.MVPLoginUser;
import com.example.loginmvp.Login.presenter.LoginPresenter;
import com.example.loginmvp.R;
import com.example.loginmvp.RegisterUser.view.RegisterUserView;
import com.example.loginmvp.databinding.ActivityLoginViewBinding;
import com.google.android.material.snackbar.Snackbar;

public class LoginView extends AppCompatActivity implements View.OnClickListener, MVPLoginUser.View {

    private ActivityLoginViewBinding loginViewBinding;
    private MVPLoginUser.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login_view);
        loginViewBinding = ActivityLoginViewBinding.inflate(getLayoutInflater());
        View view = loginViewBinding.getRoot();
        setContentView(view);

        presenter = new LoginPresenter(this, this);

        loginViewBinding.buttonLogin.setOnClickListener(this);
        loginViewBinding.textViewLinkToRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button_login:
                presenter.loginButtonClicked();
                break;
            case R.id.text_view_link_to_register:
                Intent i = new Intent(this, RegisterUserView.class);
                startActivity(i);
                break;
                //presenter.linkRegisterClicked();
        }
    }

    @Override
    public void showUsernameEmptyField() {
        loginViewBinding.editTextUsername.setError("campo obligatorio");
    }

    @Override
    public void showPasswordEmptyField() {
        loginViewBinding.editTextPassword.setError("campo obligatorio");
    }

    @Override
    public void showWrongUserPassword() {
        Toast.makeText(this, "Usuario y/o contraseña incorrecta", Toast.LENGTH_LONG).show();
    }

    @Override
    public void operationSuccesfull(String username) {
        Toast.makeText(this, "bienvenido " + username, Toast.LENGTH_LONG).show();
    }

    @Override
    public void userNotExists() {
        Toast.makeText(this, "Usuario no registrado", Toast.LENGTH_LONG).show();
    }

    @Override
    public String getUserName() {
        return loginViewBinding.editTextUsername.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return loginViewBinding.editTextPassword.getText().toString().trim();
    }

    @Override
    public void toActivityRegisterUser() {
        Intent i = new Intent(this, RegisterUserView.class);
        startActivity(i);
    }


}