package com.example.sanitizationchecklist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Calendar;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "TOUCHHELPER.DB";
    public static final String TABLE_NAME = "REDENABLER_TABLE";
    public static final String COL_1 = "AREA";
    public static final String COL_2 = "TP";
    public static final String COL_3 = "CA";
    public static final String COL_4 = "TOUCH";
    public static final String COL_5 = "ENTRY_TIME";

    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);


    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+" (AREA TEXT,TP TEXT,CA TEXT,TOUCH TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
//        onCreate(db);
    }

    public boolean insertDate(String area,String tp,String ca,String touch){
        SQLiteDatabase db = this.getWritableDatabase();
//        db.rawQuery("DELETE FROM "+TABLE_NAME,null);

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,area.trim());
        contentValues.put(COL_2,tp.trim());
        contentValues.put(COL_3,ca.trim());
        String date = getTime();
        contentValues.put(COL_4,date);

//        contentValues.put(COL_5,date);
        long result =  db.insert(TABLE_NAME,null,contentValues);
        if (result==-1)
            return false;
        else
            return true;
    }
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return res;
    }
    public Cursor getData2(String area,String tp){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor res = db.rawQuery("select distinct * from " +TABLE_NAME+" where AREA = ? and TP = ?", new String[]{area.trim(),tp.trim()});
        return res;
    }
    public boolean updateData(String area,String tp,String ca,String touch){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,area);
        contentValues.put(COL_2,tp);
        contentValues.put(COL_3,ca);
        String date = getTime();
        contentValues.put(COL_4,date);

//        contentValues.put(COL_5,date);
        long result =  db.update(TABLE_NAME,contentValues,"TP = ? and CA = ?",new String[]{tp,ca});
        if (result==-1)
            return false;
        else
            return true;
    }
    public String getTime(){

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        String dated = ""+year+""+month+""+day;
        Log.d("DatabaseData","Inside gettime"+" "+dated);
        return dated;
    }

}
