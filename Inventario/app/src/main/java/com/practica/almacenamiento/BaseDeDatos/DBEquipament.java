package com.practica.almacenamiento.BaseDeDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBEquipos extends SQLiteOpenHelper {

    private static final String DB_NAME = "DB_Equip.sqlite";
    private static final int DB_VERSION = 1;

    private static final String EQUIP_TABLE_CREATE = "CREATE TABLE equip(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nick TEXT, nombre TEXT, email TEXT, password TEXT)";

    public DBEquipos(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
