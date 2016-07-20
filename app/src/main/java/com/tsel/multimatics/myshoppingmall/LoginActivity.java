package com.tsel.multimatics.myshoppingmall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txRegister;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().setTitle("Login");

        txRegister = (TextView) findViewById(R.id.log_reg);
        txRegister.setOnClickListener(this);

        btnLogin = (Button) findViewById(R.id.log_login);
        btnLogin.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        Intent intent = null;
        switch (view.getId()) {
            case R.id.log_reg:
                intent = new Intent(LoginActivity.this, RegisterActivity.class);
                break;
            case R.id.log_login:
                intent = new Intent(LoginActivity.this, MainActivity.class);
                break;
        }

        if (intent != null) {
            startActivity(intent);
        }


    }
}
