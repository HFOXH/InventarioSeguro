package com.practica.almacenamiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    private EditText Email, PassW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = findViewById(R.id.TxCL);
        PassW = findViewById(R.id.TxPL);

    }

    public void SingUp (View view){

        Intent SingUp = new Intent(this, Principal.class);

        SingUp.putExtra("Email.U", Email.getText().toString());
        SingUp.putExtra("PassWord.U", PassW.getText().toString());

        startActivity(SingUp);

    }


}