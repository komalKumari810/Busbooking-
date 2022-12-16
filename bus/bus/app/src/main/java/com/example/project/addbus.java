package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addbus extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbus);

        EditText busid = findViewById(R.id.id);
        EditText from = findViewById(R.id.from);
        EditText to = findViewById(R.id.to);
        EditText dt = findViewById(R.id.date);
        EditText seats = findViewById(R.id.seats);
        Button addbus = findViewById(R.id.addbus);
        Button back1 =findViewById(R.id.button2);
        DBHelper DB = new DBHelper(this);


        addbus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = busid.getText().toString();
                String departure = from.getText().toString();
                String arrival = to.getText().toString();
                String date = dt.getText().toString();
                String total_seats = seats.getText().toString();

                if (id.equals("") || departure.equals("") || arrival.equals("") || date.equals("") || total_seats.equals(""))
                {
                    Toast.makeText(addbus.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean checkid= DB.checkid(id);
                    if (checkid==false){
                        Boolean insert = DB.insertBus(id,departure,arrival,date,total_seats);
                        if (insert==true){
                            Toast.makeText(addbus.this, "Bus has been added", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), adminpanel.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(addbus.this, "ERROR", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(addbus.this, "ID already exists", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        /*back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), adminpanel.class);
                startActivity(intent);
            }
        });*/

        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), adminpanel.class);
                startActivity(intent);
            }
        });

    }

    public static class adminlogin extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_adminlogin);

            EditText username = findViewById(R.id.user);
            EditText password = findViewById(R.id.pass);
            Button signin = findViewById(R.id.login);
            Button signup = findViewById(R.id.signup);
            Button back = findViewById(R.id.button01);
            DBHelper DB = new DBHelper(this);

            signin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String user = username.getText().toString();
                    String pass = password.getText().toString();

                    if (user.equals("") || pass.equals(""))
                        Toast.makeText(adminlogin.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                    else{
                        Boolean checkadminuserpass = DB.checkadminusernamepassword(user, pass);
                        if (checkadminuserpass==true){
                            Toast.makeText(adminlogin.this, "LogIn Successful", Toast.LENGTH_SHORT).show();
                            Intent intent= new Intent(getApplicationContext(), adminpanel.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(adminlogin.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });

            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            });

            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), adminsignup.class);
                    startActivity(intent);
                }
            });
        }
    }
}