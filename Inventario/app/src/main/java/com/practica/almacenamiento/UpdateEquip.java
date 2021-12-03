package com.practica.almacenamiento;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.practica.almacenamiento.BaseDeDatos.DBEquipament;

public class UpDateEquipament extends AppCompatActivity {

    private int idEquipament;
    private DBEquipament DBconection;

    private EditText NameE, DescripE, CantE, PreciE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_date_equipament);

        NameE = findViewById(R.id.Tx_NameUpDate);
        DescripE = findViewById(R.id.Tx_DescripUpDate);
        CantE = findViewById(R.id.Tx_CantUpDate);
        PreciE = findViewById(R.id.Tx_PrecioUpDate);

        idEquipament = getIntent().getIntExtra("Equip",0);
        ChargeEquip();

    }

    public void ChargeEquip(){

        DBconection = new DBEquipament(this);
        String sentence = "SELECT * FROM personas WHERE _id = ?";
        String[] params = new String[]{String.valueOf(idEquipament)};

        Cursor result = DBconection.getData(sentence,params);
        result.moveToFirst();

        NameE.setText(result.getString(1));
        DescripE.setText(result.getString(2));
        CantE.setText(result.getString(3));
        PreciE.setText(result.getString(4));

    }

    public void UpDateEquip(View view){

        String tabla = "equip";
        ContentValues cv = new ContentValues();
        cv.put("name", NameE.getText().toString());
        cv.put("descrip", DescripE.getText().toString());
        cv.put("cant", CantE.getText().toString());
        cv.put("precio", PreciE.getText().toString());
        String whereClause = "_id = ?";
        String[] params = new String[]{String.valueOf(idEquipament)};
        int rows = DBconection.updateData(tabla, cv, whereClause, params);
        if (rows > 0) {
            Toast.makeText(this, "Equipo actualizado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No se pudo actualizar el equipo", Toast.LENGTH_SHORT).show();
        }

    }

    public void DeleteEquip (View view){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Está seguro?");
        builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String tabla = "equip";
                String whereClause = "_id = ?";
                String[] params = new String[]{String.valueOf(idEquipament)};
                int rows = DBconection.deleteData(tabla, whereClause, params);

                if (rows > 0) {
                    Toast.makeText(UpDateEquipament.this, "Equipo eliminado", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(UpDateEquipament.this, "No se pudo eliminar el Equipo", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Do nothing
            }
        });
        builder.create();
        builder.show();

    }

    public void goToEquip(View view){

        Intent goToEquip = new Intent(this, ListViewEquipament.class);
        startActivity(goToEquip);

    }

}