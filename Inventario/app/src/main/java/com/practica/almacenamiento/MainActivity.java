package com.practica.almacenamiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.practica.almacenamiento.BaseDeDatos.UserApp;

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

        UserApp ConectionDB = new UserApp(this);
        String sentence ="SELECT*FROM userApp";

        Cursor results = ConectionDB.getData(sentence, null);

        if (results.getCount()==0){

            Toast.makeText(this, "No hay usuarios registrados", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Por favor registre un usuario", Toast.LENGTH_LONG).show();

        } else {

            Intent b = new Intent(this, Login.class);
            startActivity(b);

        }

    }

}