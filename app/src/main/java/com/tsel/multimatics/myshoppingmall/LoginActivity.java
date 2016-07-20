package com.tsel.multimatics.myshoppingmall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txRegister;
    private Button btnLogin;

    private EditText editUsername, editPasswd;

    private AppPreference appPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().setTitle("Login");

        editUsername = (EditText) findViewById(R.id.log_username);
        editPasswd = (EditText) findViewById(R.id.log_password);


        txRegister = (TextView) findViewById(R.id.log_reg);
        txRegister.setOnClickListener(this);

        btnLogin = (Button) findViewById(R.id.log_login);
        btnLogin.setOnClickListener(this);

        appPreference = new AppPreference(LoginActivity.this);


    }

    @Override
    public void onClick(View view) {

        Intent intent = null;
        boolean isLogin = false;

        switch (view.getId()) {
            case R.id.log_reg:
                intent = new Intent(LoginActivity.this, RegisterActivity.class);
                break;
            case R.id.log_login:
                intent = new Intent(LoginActivity.this, MainActivity.class);

                String username = editUsername.getText().toString().trim();
                String passwd = editPasswd.getText().toString().trim();

                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(passwd )) {
                    Toast.makeText(LoginActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else {
                    appPreference.setUsername(username);
                    intent = new Intent(LoginActivity.this, MainActivity.class);

                    isLogin = true;
                }


                break;
        }

        if (intent != null) {
            startActivity(intent);
            if (isLogin) {
                finish();
            }
        }


    }
}
