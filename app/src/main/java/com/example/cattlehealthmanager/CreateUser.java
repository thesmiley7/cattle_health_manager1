package com.example.cattlehealthmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class CreateUser extends AppCompatActivity {
    private TextInputEditText usernamecreate, email, createpass, confirmpass;
    private Button adduser, cancel_buttonuser;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.createuser);

        usernamecreate = findViewById(R.id.usernamecreate);
        email = findViewById(R.id.email);
        createpass = findViewById(R.id.createpass);
        confirmpass = findViewById(R.id.confirmpass);
        db = new DatabaseHelper(this);

        adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String createUser = usernamecreate.getText().toString();
                String createEmail = email.getText().toString();
                String createPass = createpass.getText().toString();
                String confirmPass = confirmpass.getText().toString();

                if (createUser.equals("") || createEmail.equals("") || createPass.equals("") || confirmPass.equals(""))
                    Toast.makeText(CreateUser.this,"Please enter all details", Toast.LENGTH_SHORT).show();
                    else {
                        if (createpass.equals(confirmpass)) {
                            Boolean insertNewData = db.insertNewData(usernamecreate);
                            if (insertNewData==false) {
                                insertNewData = db.insertNewData(usernamecreate, createpass);
                                if (insertNewData==true){
                                    Toast.makeText(CreateUser.this,"User Created", Toast.LENGTH_SHORT).show();

                                    Intent i = new Intent(CreateUser.this, DashboardActivity.class);
                                    startActivity(i);
                                }else{
                                    Toast.makeText(CreateUser.this, "User already exists", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                }


            }
        });

        cancel_buttonuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
