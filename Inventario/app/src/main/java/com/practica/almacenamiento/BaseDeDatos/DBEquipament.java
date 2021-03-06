package com.practica.almacenamiento.BaseDeDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBEquipament extends SQLiteOpenHelper {

    private static final String DB_NAME = "DB_Equip.sqlite";
    private static final int DB_VERSION = 1;

    private static final String EQUIP_TABLE_CREATE = "CREATE TABLE equip(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name TEXT, descrip TEXT, cant TEXT, precio REAL)";

    public DBEquipament(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(EQUIP_TABLE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertData (String sentence){

        boolean success = false;
        try {
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL(sentence);
            success = true;
        } catch (Exception e) {
            success = false;
        }
        return success;
    }

    public Cursor getData (String sentence, String[] params) {

        SQLiteDatabase GetDB = getReadableDatabase();
        Cursor cu = GetDB.rawQuery(sentence, params);
        return cu;

    }

    public int deleteData(String table, String whereClause, String[] params) {
        SQLiteDatabase db = getWritableDatabase();
        int nRows = db.delete(table, whereClause, params);
        return nRows;
    }

    public int updateData(String table, ContentValues cv, String whereClause, String[] params) {
        SQLiteDatabase db = getWritableDatabase();
        int nRows = db.update(table, cv, whereClause, params);
        return nRows;
    }
}
