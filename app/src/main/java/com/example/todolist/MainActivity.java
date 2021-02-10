package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private AppCompatEditText txt_name;
    private AppCompatEditText txt_phoneNumber;
    private AppCompatButton btn_login;
    private AppCompatCheckBox ch_rememberMe;
    private ApplicationSharedPref sharedPref;
    private String username;
    private String phonenumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPref = new ApplicationSharedPref(this);

        init();



        ch_rememberMe.setChecked(sharedPref.getRememberMe());
        if (ch_rememberMe.isChecked()) {

            txt_name.setText(sharedPref.getName());
            txt_phoneNumber.setText(sharedPref.getPhone());


        }
        btn_login.setOnClickListener(v -> {

            username = txt_name.getText().toString();
            phonenumber = txt_phoneNumber.getText().toString();
            checkUsernameAndPhone(username,phonenumber);
            sharedPref.setRememberMe(ch_rememberMe.isChecked());

            if (ch_rememberMe.isChecked()) {
                sharedPref.savedUsernameAndPhone(username, phonenumber);
            }
            Intent i = new Intent(MainActivity.this, BoardActivity.class);
            startActivity(i);

        });


    }

    private void checkUsernameAndPhone(String username, String phonenumber) {
        if (username.equals("") || phonenumber.equals("")) {
            Toast.makeText(MainActivity.this, "username or phone number is empty !", Toast.LENGTH_SHORT).show();
        }
    }

    public void init() {
        txt_name = findViewById(R.id.txt_name);
        txt_phoneNumber = findViewById(R.id.txt_phoneNumber);
        btn_login = findViewById(R.id.btn_login);
        ch_rememberMe = findViewById(R.id.ch_remember);
    }

}