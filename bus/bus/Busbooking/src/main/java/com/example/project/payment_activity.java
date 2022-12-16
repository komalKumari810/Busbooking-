package com.example.project;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class payment_activity extends AppCompatActivity {

     //cardForm;
    Button buy;
    AlertDialog.Builder alertBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Button cancel = findViewById(R.id.button05);

        //cardForm = findViewById(R.id.card_form);
        buy = findViewById(R.id.btnBuy);





    }
}