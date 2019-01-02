package com.example.enji.uas_resep;

/**
 * Created by enji on 1/27/2018.
 */

import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DBDataSource {

    private SQLiteDatabase database;

    private DBHelper dbHelper;

    private String[] allColumns = {DBHelper.COLUMN_ID,
            DBHelper.COLUMN_NAME, DBHelper.COLUMN_BAHAN, DBHelper.COLUMN_CARA};

    public DBDataSource(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Resep createResep(String nama, String bahan, String cara) {

        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_NAME, nama);
        values.put(DBHelper.COLUMN_BAHAN, bahan);
        values.put(DBHelper.COLUMN_CARA, cara);

        long insertId = database.insert(DBHelper.TABLE_NAME, null,
                values);

        Cursor cursor = database.query(DBHelper.TABLE_NAME,
                allColumns, DBHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);

        cursor.moveToFirst();

        Resep newResep = cursorToResep(cursor);

        cursor.close();

        return  newResep;
    }
    private Resep cursorToResep(Cursor cursor) {

        Resep resep = new Resep();

        Log.v("info", "The getLONG"+cursor.getLong(0));
        Log.v("info", "The setLatLng"+cursor.getString(1)+","+cursor.getString(2));

        resep.setId(cursor.getLong(0));
        resep.setNama_resep(cursor.getString(1));
        resep.setBahan(cursor.getString(2));
        resep.setCara_pembuatan(cursor.getString(3));

        return resep;
    }

    public ArrayList<Resep> getAllResep() {
        ArrayList<Resep> daftarResep = new ArrayList<Resep>();

        Cursor cursor = database.query(DBHelper.TABLE_NAME,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Resep Resep = cursorToResep(cursor);
            daftarResep.add(Resep);
            cursor.moveToNext();
        }

        cursor.close();
        return daftarResep;
    }

    public Resep getResep(long id) {
        Resep Resep = new Resep();

        Cursor cursor = database.query(DBHelper.TABLE_NAME, allColumns, "_id =" +
                id, null, null, null, null);

        cursor.moveToFirst();

        Resep = cursorToResep(cursor);

        cursor.close();

        return Resep;
    }

    public void updateResep(Resep b) {

        String strFilter = "_id=" + b.getId();

        ContentValues args = new ContentValues();

        args.put(DBHelper.COLUMN_NAME, b.getNama_resep());
        args.put(DBHelper.COLUMN_BAHAN, b.getBahan());
        args.put(DBHelper.COLUMN_CARA, b.getCara_pembuatan());

        database.update(DBHelper.TABLE_NAME, args, strFilter, null);
    }

    public void deleteResep(long id) {
        String strFilter = "_id=" + id;
        database.delete(DBHelper.TABLE_NAME, strFilter, null);
    }


}