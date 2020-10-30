package com.example.sanitizationchecklist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Monitor extends AppCompatActivity {
    JSONObject jo = null;
    JSONArray arr = null;
    RecyclerView recyclerView;
    String[] area = new String[500];
    String[] touchPoint= new String[500];
    String[] contactArea= new String[500];
    String[] remarks= new String[500];
    String[] entryTime= new String[500];
    String[] entryBy= new String[500];
    String[] score= new String[500];
    String[] entryByDesg= new String[500];
    int j=0;
    String touchpoint = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);
        String report = "";
        SharedPreferences pref=getApplicationContext().getSharedPreferences("MyPref",0);
        report = pref.getString("report","Power Login");
        touchpoint = getIntent().getStringExtra("touchpoint");
        Log.d("responsej",report);
        try {
             jo = new JSONObject(report);
             arr = jo.getJSONArray("Report");

//             Log.d("Areaa",""+arr);

            for (int i = 0; i < arr.length(); i++)
            {
                String sample = arr.getJSONObject(i).getString("Area");
                area[i] = sample;

                Log.d("Areaa",""+sample+" "+touchpoint+i);
                if(touchpoint.equalsIgnoreCase(arr.getJSONObject(i).optString("tp"))){
                try{contactArea[j] = arr.getJSONObject(i).getString("ca");}catch (JSONException | NullPointerException e){e.printStackTrace();Log.d("Areaa","contactArea"+e);contactArea[i] = "";}
                try{remarks[j] = arr.getJSONObject(i).getString("remarks");}catch (JSONException | NullPointerException e){e.printStackTrace();Log.d("Areaa","remarks"+e);remarks[j] = "NOT UPDATED";}
                try{score[j] = arr.getJSONObject(i).getString("score");}catch (JSONException | NullPointerException e){e.printStackTrace();Log.d("Areaa","score"+e);score[j] = "NOT UPDATED";}
           j++; }
        }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        init();


    }
    @SuppressLint("SetTextI18n")
    public void init()  {
        TextView textView = findViewById(R.id.Area);
        textView.setText(area[1]);
        TextView textView2 = findViewById(R.id.TPTV);
        textView2.setText(touchpoint);
        TableLayout stk = findViewById(R.id.table_main);
        stk.setClickable(true);
        TableRow tbrow0 = new TableRow(this);
        TextView tv0 = new TextView(this);
        tv0.setText("S.NO  ");
        tv0.setTextColor(Color.WHITE);
        tbrow0.addView(tv0);
        TextView tv1 = new TextView(this);
        tv1.setText("CONTACT AREA     ");
        tv1.setTextColor(Color.WHITE);
        tbrow0.addView(tv1);
        TextView tv2 = new TextView(this);
        tv2.setText("SCORE");
        tv2.setTextColor(Color.WHITE);
        tbrow0.addView(tv2);
        TextView tv3 = new TextView(this);
        tv3.setText("   Remarks");
        tv3.setTextColor(Color.WHITE);
        tbrow0.addView(tv3);


        stk.addView(tbrow0);
        for (int i = 0; i < j; i++) {
            TableRow tbrow = new TableRow(this);
            TextView t0v = new TextView(this);
            Log.d("Areaa",""+touchPoint[i]+i);
            t0v.setText((i+1)+" ");
            t0v.setTextColor(Color.WHITE);
//            tv0.setMaxWidth(400);
            tbrow.addView(t0v);
            TextView t1v = new TextView(this);
//            t1v.setGravity(Gravity.CENTER);
            t1v.setTextSize(15);

            t1v.setText(contactArea[i]+"   ");
            t1v.setTextColor(Color.WHITE);
            t1v.setMaxWidth(350);
//            t1v.setGravity(Gravity.CENTER);
            t1v.setTextSize(15);

            tbrow.addView(t1v);
            TextView t2v = new TextView(this);
            if("NOT UPDATED".equalsIgnoreCase(score[i])){
                t2v.setText("   "+score[i]+"    ");
                t2v.setTextColor(Color.RED);}else{
                t2v.setText("   "+score[i]+"    ");
                t2v.setTextColor(Color.WHITE);
            }
//            t2v.setGravity(Gravity.CENTER);
            t2v.setTextSize(15);
            t2v.setMaxWidth(300);

            tbrow.addView(t2v);
            TextView t3v = new TextView(this);
            if("NOT UPDATED".equalsIgnoreCase(remarks[i])){

            t3v.setText("   "+remarks[i]+"   ");
            t3v.setTextColor(Color.RED);}else{

                t3v.setText("   "+remarks[i]+"   ");
                t3v.setTextColor(Color.WHITE);
            }
//            t3v.setGravity(Gravity.CENTER);
            t3v.setTextSize(15);
            t3v.setMaxWidth(300);
            tbrow.addView(t3v);

//            TextView t4v = new TextView(this);
//            t4v.setText(arr.getJSONObject(i).getString("ca"));
//            t4v.setTextColor(Color.WHITE);
//            t4v.setGravity(Gravity.CENTER);
//            t4v.setTextSize(15);
//            tbrow.addView(t4v);
            stk.addView(tbrow);
        }
    }
}