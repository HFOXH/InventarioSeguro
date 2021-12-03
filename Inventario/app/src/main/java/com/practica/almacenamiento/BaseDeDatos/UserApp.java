package com.practica.almacenamiento.BaseDeDatos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserApp extends SQLiteOpenHelper {

    private static final String DB_NAME = "DB_Users.sqlite";
    private static final int DB_VERSION = 2;

    private static final String USERS_TABLE_CREATE = "CREATE TABLE userApp(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nick TEXT, nombre TEXT, email TEXT, password TEXT)";

    public UserApp(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(USERS_TABLE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertData (String sentence){

        SQLiteDatabase InsertDB = getWritableDatabase();
        InsertDB.execSQL(sentence);

    }

    public Cursor getData (String sentence, String[] params) {

        SQLiteDatabase GetDB = getReadableDatabase();
        Cursor cu = GetDB.rawQuery(sentence, params);
        return cu;

    }
}
