package com.practica.almacenamiento.listViews;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.practica.almacenamiento.R;
import com.practica.almacenamiento.model.Equipament;

import java.util.ArrayList;

public class EquipListViewsAdapter extends ArrayAdapter<Equipament> {

    ArrayList<Equipament> Equip;
    Context context;

    public EquipListViewsAdapter(Context context, ArrayList<Equipament> items) {
        super(context, R.layout.list_equipament, items);

        this.context = context;
        Equip = items;

    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

        if (convertView == null){

            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.list_equipament, null);

        }

        TextView equipName = convertView.findViewById(R.id.Tv_Name);
        TextView equipDescrip = convertView.findViewById(R.id.Tv_Desc);
        TextView equipCant = convertView.findViewById(R.id.Tv_Cant);
        TextView equiPrecio = convertView.findViewById(R.id.Tv_Precio);

        equipName.setText(Equip.get(position).getNombre());
        equipDescrip.setText(Equip.get(position).getDescrip());
        equipCant.setText(Equip.get(position).getCant());
        equiPrecio.setText(String.valueOf(Equip.get(position).getPrecio()));

        return convertView;

    }

}
