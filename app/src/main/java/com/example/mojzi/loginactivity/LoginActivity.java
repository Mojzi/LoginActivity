package com.example.mojzi.loginactivity;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

/**
 * Created by mojzi on 04.07.17.
 * Main Activity
 */

public class LoginActivity extends AppCompatActivity {

    private EditText loginEt;
    private EditText passwordEt;

    private LoginValidator loginValidator;
    private String login;
    private String password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button loginButton = (Button) findViewById(R.id.LoginButton);
        loginEt = (EditText) findViewById(R.id.LoginEditText);
        passwordEt = (EditText) findViewById(R.id.PasswordEditText);
        CheckBox showPasswordChb = (CheckBox) findViewById(R.id.ShowPasswordCheckBox);
        loginValidator = new LoginValidator();
        loginValidator.fillSampleData();
        final Intent intent = new Intent(this, PositionActivity.class);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loginValidator.loginCorrect(login, password)) {
                    startActivity(intent);
                }
                else {
                    Snackbar.make(view, R.string.text_view_wrong_data, Snackbar.LENGTH_SHORT).show();
                }

            }
        });

        loginEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                login = loginEt.getText().toString();
            }
        });

        passwordEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                password = passwordEt.getText().toString();
            }
        });

        showPasswordChb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    passwordEt.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }
                else {
                    passwordEt.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                }
            }
        });

    }
}
