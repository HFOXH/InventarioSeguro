package com.practica.almacenamiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CrearUsuario(View view){

        Intent a = new Intent(this, CrearUsuario.class);

        startActivity(a);

    }

    public void login(View view){

        Intent b = new Intent(this, Login.class);

        startActivity(b);

    }

}