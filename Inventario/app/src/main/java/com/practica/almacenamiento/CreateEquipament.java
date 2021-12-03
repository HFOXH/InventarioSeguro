package com.practica.almacenamiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.practica.almacenamiento.BaseDeDatos.DBEquipament;

public class CreateEquipament extends AppCompatActivity {

    private EditText NameE, DescripE, CantE, PreciE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_equipament);

        NameE = findViewById(R.id.Tx_NameEquip);
        DescripE = findViewById(R.id.Tx_DescripE);
        CantE = findViewById(R.id.Tx_CantE);
        PreciE = findViewById(R.id.Tx_PrecioE);

    }

    public void CrearEquipo(View view){

        String nameEq = NameE.getText().toString();
        String DescripEq = DescripE.getText().toString();
        String CantEq = CantE.getText().toString();
        String PrecioEq = PreciE.getText().toString();

        // DB
        DBEquipament DBConection = new DBEquipament(this);
        String insert_query = "INSERT INTO equip (name, descrip, cant, precio) " +
                "VALUES ('"+nameEq+"', '"+DescripEq+"', '"+CantEq+"', '"+PrecioEq+"')";

        boolean success = DBConection.insertData(insert_query);
        if (success) {
            Toast.makeText(this, "Equipo guardado con éxito", Toast.LENGTH_LONG).show();
            limpiarFormulario();
            Intent goToEquip = new Intent(this, ListViewEquipament.class);
            startActivity(goToEquip);
        } else {
            Toast.makeText(this, "Error al guardar la equipo", Toast.LENGTH_LONG).show();
        }

    }

    public void limpiarFormulario() {

        NameE.setText("");
        DescripE.setText("");
        CantE.setText("");
        PreciE.setText("");

    }

}