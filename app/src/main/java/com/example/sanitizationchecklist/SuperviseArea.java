package com.example.sanitizationchecklist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SuperviseArea extends AppCompatActivity implements View.OnClickListener {
    int area = 0;
    String report,areas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervise_area);

        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);

    }

    private void postRequest() {
        Log.d("responseFr","button clicked");

        RequestQueue requestQueue = Volley.newRequestQueue(SuperviseArea.this);
        //String URL = "http://192.168.0.11:8080/login";
//        String URL = "http://192.168.0.7:8080/getreport";
        String URL = (new Parameters().returnParameter())+"getreport";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                report = response;
                SharedPreferences pref=getApplicationContext().getSharedPreferences("MyPref",0);
                SharedPreferences.Editor editor=pref.edit();

                editor.putString("report",response);
                Log.d("responsea",report);
                editor.commit();



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("errorVoll",""+error);
                //Toast.makeText(Submit.this,"Cannot Access Web Service",Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String,String> getParams(){

                Map<String,String> params = new HashMap<String, String>();
                params.put("areaId",""+area);


                return params;
            }
            @Override
            public Map<String,String> getHeaders(){
                Map<String,String> params= new HashMap<String, String>();
                params.put("Content-Type","application/x-www-form-urlencoded");
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    @Override
    public void onClick(View view) {
        postRequest();
        switch (view.getId()){
        case R.id.button:
            area = 1;
        areas = getString(R.string.a1);
        Intent intent = new Intent(SuperviseArea.this,Monitor.class);
            intent.putExtra("touchpoint","Check In Hall");
        startActivity(intent);
        break;


        case R.id.button2:
            area = 2;
        areas = getString(R.string.a2);
        Intent intent2 = new Intent(SuperviseArea.this,TouchPoint.class);
        intent2.putExtra("Area",areas);
        startActivity(intent2);

        break;
        case R.id.button3:
            area = 3;
        areas = getString(R.string.a3);
        Intent intent3 = new Intent(SuperviseArea.this,TouchPoint.class);
        intent3.putExtra("Area",areas);
        startActivity(intent3);

        break;
        case R.id.button4:
            area = 4;
        areas = getString(R.string.a4);
        Intent intent4 = new Intent(SuperviseArea.this,TouchPoint.class);
        intent4.putExtra("Area",areas);
        startActivity(intent4);

        break;
        case R.id.button5:
            area = 5;
        areas = getString(R.string.a5);
        Intent intent5 = new Intent(SuperviseArea.this,TouchPoint.class);
        intent5.putExtra("Area",areas);
        startActivity(intent5);

        break;
        case R.id.button6:
            area = 6;
        areas = getString(R.string.a6);
        Intent intent6 = new Intent(SuperviseArea.this,TouchPoint.class);
        intent6.putExtra("Area",areas);
        startActivity(intent6);

        break;
        case R.id.button7:
            area = 7;
        areas = getString(R.string.a7);
        Intent intent7 = new Intent(SuperviseArea.this,TouchPoint.class);
        intent7.putExtra("Area",areas);
        startActivity(intent7);

        break;

        }}
    }
