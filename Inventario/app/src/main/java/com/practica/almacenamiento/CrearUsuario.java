package com.practica.almacenamiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CrearUsuario extends AppCompatActivity {

    private EditText TxN, TxE, TxP,TxVP;
    String PV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_usuario);

        TxN = findViewById(R.id.Tx_Nom);
        TxE = findViewById(R.id.Tx_Correo);
        TxP = findViewById(R.id.Tx_Contraseña);
        TxVP = findViewById(R.id.Tx_Validación_Contraseña);

    }

    public void SignIn (View view){

       String Name = TxN.getText().toString();
       String Email = TxE.getText().toString();
       String PassW = TxP.getText().toString();
       String VPassW = TxVP.getText().toString();

       if (PassW == VPassW){

           Intent SingIn = new Intent(this, Principal.class);

           SingIn.putExtra("Name.NU", Name);
           SingIn.putExtra("Email.NU",Email);
           SingIn.putExtra("Password.NU", PassW);

           startActivity(SingIn);

       } else {

           Toast.makeText(this, "Las contraseñas no son iguales", Toast.LENGTH_SHORT).show();

       }

    }


}