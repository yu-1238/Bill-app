package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class Database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "bill.db";
    private static final int DATABASE_VERSION = 1;

    public Database(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        createTable(sqLiteDatabase);
    }


    private void createTable(SQLiteDatabase db){
        db.execSQL("create table BillInfo(" +
                "id integer primary key autoincrement," +
                "shop text," +
                "type text,"+
                "money text,"+
                "time text)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}