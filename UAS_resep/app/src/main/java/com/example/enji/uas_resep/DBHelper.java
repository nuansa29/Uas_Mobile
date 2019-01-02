package com.example.enji.uas_resep;

/**
 * Created by enji on 1/27/2018.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "data_resep";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "nama_resep";
    public static final String COLUMN_BAHAN = "bahan";
    public static final String COLUMN_CARA = "cara_pembuatan";
    private static final String db_name ="resep.db";
    private static final int db_version=1;

    private static final String db_create = "create table "
            + TABLE_NAME + "("
            + COLUMN_ID +" integer primary key autoincrement, "
            + COLUMN_NAME+ " varchar(50) not null, "
            + COLUMN_BAHAN+ " varchar(100) not null, "
            + COLUMN_CARA+ " varchar(200) not null);";
    public DBHelper(Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(db_create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBHelper.class.getName(),"Upgrading database from version " +
                oldVersion + " to "
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
