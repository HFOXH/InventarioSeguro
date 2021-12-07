package com.practica.almacenamiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.practica.almacenamiento.BaseDeDatos.DBEquipament;
import com.practica.almacenamiento.listViews.EquipListViewsAdapter;
import com.practica.almacenamiento.model.Equipament;

import java.util.ArrayList;

public class ListViewEquipament extends AppCompatActivity {

    private ArrayList<Equipament> equipList;
    private static ListView listView;
    private static EquipListViewsAdapter AdapterCreated;

    int idEquipament;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_equipament);

        equipList = new ArrayList<>();
        listView = findViewById(R.id.Lv_Equipament);

        showEquip();

        listView.setClickable(true);
        try {

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    Equipament seleccionado = (Equipament) listView.getItemAtPosition(position);
                    idEquipament = seleccionado.getId();
                    goToEquipUpDate(idEquipament);
                }
            });

        } catch (Exception e){
            Toast.makeText(this, "Error " + e, Toast.LENGTH_LONG).show();
        }

    }

    public void showEquip(){

        String name;
        String descrip;
        int id =0;
        String cant;
        String precio;

        DBEquipament DBconection = new DBEquipament(this);
        String sentence = "SELECT*FROM equip";

        Cursor result = DBconection.getData(sentence, null);

        try {

            result.moveToFirst();
            do {

                id = result.getInt(0);
                name =result.getString(1);
                descrip = result.getString(2);
                cant = result.getString(3);
                precio = result.getString(4);

                Equipament newEquipament = new Equipament(name, descrip, cant, precio);
                newEquipament.setId(id);

                equipList.add(newEquipament);

            }while (result.moveToNext());

            AdapterCreated = new EquipListViewsAdapter(this, equipList);
            listView.setAdapter(AdapterCreated);

        }catch (Exception e){

            Toast.makeText(this , "No se pudo generar equipos  " + e, Toast.LENGTH_SHORT).show();

        } finally {

            result.close();

        }

    }

    public void goToEquipUpDate(int idEquipament){

        Intent intentUpDate = new Intent(this, EquipUpD.class);
        intentUpDate.putExtra("Equip", idEquipament);
        startActivity(intentUpDate);

    }

    public void goToCreateEquip(View view){

        Intent goToCreat = new Intent(this, CreateEquipament.class);
        startActivity(goToCreat);

    }

<<<<<<< HEAD
    public void goToGPS(View view){

        Intent goToGPS = new Intent(this, GPSActivity.class);
        startActivity(goToGPS);

    }

=======
>>>>>>> 497d4af9414d2554649982fd8ce894733fa2a1ee
}