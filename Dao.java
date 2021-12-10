package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;



import java.util.ArrayList;
import java.util.List;



public class Dao {
    private Database du;
    private SQLiteDatabase db;

    public Dao(Context context){
        du = new Database(context);
        db = du.getWritableDatabase();
    }



    public void addData(String tableName,String[] key,String[] values){
        ContentValues contentValues = new ContentValues();
        for(int i = 0; i < key.length; i ++){
            contentValues.put(key[i],values[i]);
        }
        db.insert(tableName,null,contentValues);
        contentValues.clear();
    }


    public int delData(String where,String[] values){
        int del_data;
        del_data = db.delete("BillInfo",where,values);
        return del_data;
    }


    public void update(String[] values){
        db.execSQL("update BillInfo set shop=?,type=?,money=?,time=? where id=? ",values);
    }


    public List<Bill> inquireData(){
        List<Bill> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("select id,shop,type,money,time" +
                " from BillInfo",null);
        while(cursor.moveToNext()){
            String billid=cursor.getString(0);
            String shop = cursor.getString(1);
            String type = cursor.getString(2);
            String money= cursor.getString(3);
            String time = cursor.getString(4);
            Bill cur=new Bill(billid, shop,money,type,time);
            list.add(cur);
        }

        return list;
    }


    public void getClose(){
        if(db != null){
            db.close();
        }
    }
}