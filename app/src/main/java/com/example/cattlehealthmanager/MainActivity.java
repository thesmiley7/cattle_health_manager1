package com.example.cattlehealthmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText username;
    private TextInputEditText password;
    private Button button;

    /*private String Username = "Admin";
    private String Password = "1234";*/

    boolean isValid = false;
    private int counter = 3;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        button = findViewById(R.id.button);
        db = new DatabaseHelper(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputUser = username.getText().toString();
                String inputPass = password.getText().toString();

                if (inputUser.equals("") || inputPass.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Please Enter All Details Correctly", Toast.LENGTH_SHORT).show();
                }else {
                    isValid = validate(inputUser, inputPass);

                    if (isValid) {
                        counter--;

                        Toast.makeText(MainActivity.this, "Incorrect Details", Toast.LENGTH_SHORT).show();

                        if (counter == 0) {
                            button.setEnabled(false);
                        }
                    }else {
                        Toast.makeText(MainActivity.this, "Login was Successful", Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(MainActivity.this, DashboardActivity.class);
                        startActivity(i);
                    }

                }
            }
        });

    }

    private boolean validate(String username, String password) {
        if (username.equals(username) && password.equals(password)) {
            return true;
        }
        return false;
    }


    /*public void Login(View v){

    }*/

    public void goCreateUser(View v){
        Intent i = new Intent(this, CreateUser.class);
        startActivity(i);
    }

    public void goToNewPass(View v){
        Intent i = new Intent(this, NewPass.class);
        startActivity(i);
    }


}