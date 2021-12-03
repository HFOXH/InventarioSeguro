package com.practica.almacenamiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.practica.almacenamiento.BaseDeDatos.UserApp;

public class CrearUsuario extends AppCompatActivity {

    private EditText TxNick, TxName, TxE, TxP,TxVP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_usuario);

        TxNick = findViewById(R.id.Tx_NameEquip);
        TxName = findViewById(R.id.Tx_DescripE);
        TxE = findViewById(R.id.Tx_CantE);
        TxP = findViewById(R.id.Tx_PrecioE);
        TxVP = findViewById(R.id.Tx_Validación_Contraseña);

    }

    public void SignUp (View view){

        String Nick = TxNick.getText().toString();
        String Name = TxName.getText().toString();
        String Email = TxE.getText().toString();
        String PassW = TxP.getText().toString();
        String VPassW = TxVP.getText().toString();

       if (PassW.equals(VPassW)){

           try {

               UserApp ConexionDB = new UserApp(this);
               String insert_query = "INSERT INTO userApp(nick, nombre, email, password)" +
                       "VALUES ('"+Nick+"','"+Name+"','"+Email+"','"+PassW+"')";

               ConexionDB.insertData(insert_query);

               Toast.makeText(this, "Registro guardado exitosamente", Toast.LENGTH_SHORT).show();

               TxNick.setText("");
               TxName.setText("");
               TxE.setText("");
               TxP.setText("");
               TxVP.setText("");

               Intent SingIn = new Intent(this, Login.class);
               startActivity(SingIn);

           }catch (Exception e){

               Toast.makeText(this, "No se pudo agregar registro", Toast.LENGTH_LONG).show();
               Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();

           }

       } else {

           Toast.makeText(this, "Las contraseñas no son iguales", Toast.LENGTH_SHORT).show();

       }

    }

}