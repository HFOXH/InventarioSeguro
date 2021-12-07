package com.practica.almacenamiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.practica.almacenamiento.BaseDeDatos.UserApp;


public class Login extends AppCompatActivity {

    private EditText EmailUser, PassW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EmailUser = findViewById(R.id.TxCL);
        PassW = findViewById(R.id.TxPL);

    }

    public void SingIn (View view){

        UserApp conexionDB = new UserApp(this);
        String sentences = "SELECT*FROM userApp";

        String Email = EmailUser.getText().toString();
        String PassWord = PassW.getText().toString();

        Cursor resultados = conexionDB.getData(sentences, null);

        try{

            resultados.moveToFirst();
            int indiceE = resultados.getColumnIndex("email");
            int indiceP = resultados.getColumnIndex("password");
            int indiceNick = resultados.getColumnIndex("nick");
            int indiceN = resultados.getColumnIndex("nombre");
            do{

                if (resultados.getString(indiceE).equals(Email)){

                    if (resultados.getString(indiceP).equals(PassWord)) {

                        SharedPreferences User_On =getSharedPreferences("UserOn", Context.MODE_PRIVATE);
                        SharedPreferences.Editor ObjUser = User_On.edit();
                        ObjUser.putString("nick",resultados.getString(indiceNick));
                        ObjUser.putString("email", resultados.getString(indiceE));
                        ObjUser.putString("name", resultados.getString(indiceN));
                        ObjUser.commit();

                        //Intent SingIn = new Intent(this, Panelt.class);
                        Intent SingIn = new Intent(this, ListViewEquipament.class);
                        startActivity(SingIn);
                    }

                }else {

                    Toast.makeText(this, "Email o contraseña incorrecta", Toast.LENGTH_SHORT).show();

                }

            }while (resultados.moveToNext());

        }catch (Exception e){

            Toast.makeText(this, "No se pudo realizar el ingreso", Toast.LENGTH_SHORT).show();

        }

    }


    /* public void goToPanel (View view){

        Intent intentPanel = new Intent(this, Panelt.class);

        startActivity(intentPanel);
    }*/


}