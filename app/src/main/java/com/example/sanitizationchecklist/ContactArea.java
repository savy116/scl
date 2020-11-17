package com.example.sanitizationchecklist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static android.graphics.Color.RED;

public class ContactArea extends AppCompatActivity implements View.OnClickListener {
    String[] Touchpoints;
    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, button10, button11, button12, button13,
            button14, button15, button16, button17, button18, button19, button20,
            button21, button22, button23, button24, button25, button26, button27,
            button28, button29, button30, button31, button32, button33, button34, button35;
    String touchPoint, Area;
    String[] contactPoints;
    String[] buttonEnablerContactArea = new String[100];
    String[] buttonEnableRed = new String[100];
    String[] buttonText = new String[100];
    String[] contactArea = new String[100];
    String report;
    DataBaseHelper myDb;
    JSONObject jo = null;
    JSONArray arr = null;
    int length = 0;
    int area_id = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_area);
        touchPoint = getIntent().getStringExtra("touchpoint");
        myDb = new DataBaseHelper(this);
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("MyPref", 0);
        Area = preferences.getString("Area", null);

        SharedPreferences pref=getApplicationContext().getSharedPreferences("MyPref",0);

        area_id = getIntent().getIntExtra("Areaid",0);
        Log.d("MyArea",""+area_id);
       // postRequest();
        report = pref.getString("report","Power Login");
//        TouchPoint tpres = new TouchPoint();
//        tpres.postRequest();

        try {
            jo = new JSONObject(report);
            arr = jo.getJSONArray("Report");

//             Log.d("Areaa",""+arr);
String touchpoint = getIntent().getStringExtra("touchpoint");
            for (int i = 0; i < arr.length(); i++)
            {
                String sample = arr.getJSONObject(i).getString("Area");


                Log.d("Areaa",""+sample+" "+touchpoint+i);
                Log.d("responsea",touchpoint+" "+arr.getJSONObject(i).optString("tp"));
                if(touchpoint.equalsIgnoreCase(arr.getJSONObject(i).optString("tp"))){
                    String score;
                    try{score = arr.getJSONObject(i).getString("score");}catch (JSONException | NullPointerException e){e.printStackTrace();Log.d("Areaa","score"+e);score = "NOT UPDATED";}
                    Log.d("contact",touchpoint+" "+arr.getJSONObject(i).optString("ca"));
                    if(score.equalsIgnoreCase("NOT UPDATED"))
                    try{contactArea[length] = arr.getJSONObject(i).getString("ca");}catch (JSONException | NullPointerException e){e.printStackTrace();Log.d("Areaa","contactArea"+e);contactArea[i] = "";}

                    length++; }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button10 = findViewById(R.id.button10);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);
        button13 = findViewById(R.id.button13);
        button14 = findViewById(R.id.button14);
        button15 = findViewById(R.id.button15);
        button16 = findViewById(R.id.button16);
        button17 = findViewById(R.id.button17);
        button18 = findViewById(R.id.button18);
        button19 = findViewById(R.id.button19);
        button20 = findViewById(R.id.button20);
        button21 = findViewById(R.id.button21);
        button22 = findViewById(R.id.button22);
        button23 = findViewById(R.id.button23);
        button24 = findViewById(R.id.button24);
        button25 = findViewById(R.id.button25);
        button26 = findViewById(R.id.button26);
        button27 = findViewById(R.id.button27);
        button28 = findViewById(R.id.button28);
        button29 = findViewById(R.id.button29);
        button30 = findViewById(R.id.button30);
        button31 = findViewById(R.id.button31);
        button32 = findViewById(R.id.button32);
        button33 = findViewById(R.id.button33);
        button34 = findViewById(R.id.button34);
        button35 = findViewById(R.id.button35);
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);
        button12.setOnClickListener(this);
        button13.setOnClickListener(this);
        button14.setOnClickListener(this);
        button15.setOnClickListener(this);
        button16.setOnClickListener(this);
        button17.setOnClickListener(this);
        button18.setOnClickListener(this);
        button19.setOnClickListener(this);
        button20.setOnClickListener(this);
        button21.setOnClickListener(this);
        button22.setOnClickListener(this);
        button23.setOnClickListener(this);
        button24.setOnClickListener(this);
        button25.setOnClickListener(this);
        button26.setOnClickListener(this);
        button27.setOnClickListener(this);
        button28.setOnClickListener(this);
        button29.setOnClickListener(this);
        button30.setOnClickListener(this);
        button31.setOnClickListener(this);
        button32.setOnClickListener(this);
        button33.setOnClickListener(this);
        button34.setOnClickListener(this);
        button35.setOnClickListener(this);



        Touchpoints = getResources().getStringArray(R.array.TouchPoint);


        int flag = 0;
        for (int i = 0; i < Touchpoints.length; i++) {


            Log.d("TouchCheck", "" + touchPoint);
            Log.d("TouchCheck", "" + Touchpoints[i]);


            if (touchPoint.equalsIgnoreCase(Touchpoints[i])) {
                flag = i + 2;
                Log.d("TouchCheck", "" + flag);
                break;
            }

        }


        switch (flag) {
            case 1:
                break;
            case 2:
                contactPoints = getResources().getStringArray(R.array.tp2);
                callSwitch(contactPoints);
                break;

            case 3:
                contactPoints = getResources().getStringArray(R.array.tp3);
                callSwitch(contactPoints);
                break;

            case 4:
                contactPoints = getResources().getStringArray(R.array.tp4);
                callSwitch(contactPoints);
                break;

            case 5:
                contactPoints = getResources().getStringArray(R.array.tp5);
                callSwitch(contactPoints);
                break;

            case 6:
                contactPoints = getResources().getStringArray(R.array.tp6);
                callSwitch(contactPoints);
                break;

            case 7:
                contactPoints = getResources().getStringArray(R.array.tp7);
                callSwitch(contactPoints);
                break;

            case 8:
                contactPoints = getResources().getStringArray(R.array.tp8);
                callSwitch(contactPoints);
                break;

            case 9:
                contactPoints = getResources().getStringArray(R.array.tp9);
                callSwitch(contactPoints);
                break;

            case 10:
                contactPoints = getResources().getStringArray(R.array.tp10);
                callSwitch(contactPoints);
                break;

            case 11:
                contactPoints = getResources().getStringArray(R.array.tp11);
                callSwitch(contactPoints);
                break;

            case 12:
                contactPoints = getResources().getStringArray(R.array.tp12);
                callSwitch(contactPoints);
                break;

            case 13:
                contactPoints = getResources().getStringArray(R.array.tp13);
                callSwitch(contactPoints);
                break;

            case 14:
                contactPoints = getResources().getStringArray(R.array.tp14);
                callSwitch(contactPoints);
                break;

            case 15:
                contactPoints = getResources().getStringArray(R.array.tp15);
                callSwitch(contactPoints);
                break;

            case 16:
                contactPoints = getResources().getStringArray(R.array.tp16);
                callSwitch(contactPoints);
                break;

            case 17:
                contactPoints = getResources().getStringArray(R.array.tp17);
                callSwitch(contactPoints);
                break;

            case 18:
                contactPoints = getResources().getStringArray(R.array.tp18);
                callSwitch(contactPoints);
                break;

            case 19:
                contactPoints = getResources().getStringArray(R.array.tp19);
                callSwitch(contactPoints);
                break;

            case 20:
                contactPoints = getResources().getStringArray(R.array.tp20);
                callSwitch(contactPoints);
                break;

            case 21:
                contactPoints = getResources().getStringArray(R.array.tp21);
                callSwitch(contactPoints);
                break;

            case 22:
                contactPoints = getResources().getStringArray(R.array.tp22);
                callSwitch(contactPoints);
                break;

            case 23:
                contactPoints = getResources().getStringArray(R.array.tp23);
                callSwitch(contactPoints);
                break;

            case 24:
                contactPoints = getResources().getStringArray(R.array.tp24);
                callSwitch(contactPoints);
                break;


        }
//        rollOverButton();

//actual red code
//        updateButtonIndicator(Area, touchPoint, "ca0");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle", "onResume invoked");
        myDb = new DataBaseHelper(this);
//        updateButtonIndicator(Area, touchPoint, "ca0");
//////////        SharedPreferences preferences = getApplicationContext().getSharedPreferences("MyPref", 0);
////////        area_id = getIntent().getIntExtra("Areaid",0);
////////        postRequest();
       // postRequest();
    }

    private void postRequest() {
        Log.d("responseFr","button clicked");
        Log.d("MyArea",""+area_id+" in post");
        RequestQueue requestQueue = Volley.newRequestQueue(ContactArea.this);
        //String URL = "http://192.168.0.11:8080/login";
//        String URL = "http://192.168.0.7:8080/getreport";
        String URL = "http://192.168.43.120:8080/getreport";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                report = response;
                SharedPreferences pref=getApplicationContext().getSharedPreferences("MyPref",0);
                SharedPreferences.Editor editor=pref.edit();

                editor.putString("report",response);
                Log.d("responses",""+response);
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
                params.put("areaId",""+area_id);


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



    private void printallids() {

        String[] contactAreasID = getResources().getStringArray(R.array.UNIQUECONTACTAREAS);
        for (int i = 0; i < contactAreasID.length; i++) {
            for (int j = 0; j < contactPoints.length; j++) {
                if (contactAreasID[i].equalsIgnoreCase(contactPoints[j])) {
                    Log.d("contactAreasID", "" + (i + 1));
                }
            }
        }


    }

    private void callSwitch(String[] contactPoints) {
        int len = contactPoints.length;
        switch (len) {

            case 0:
                button0.setVisibility(View.GONE);
                button1.setVisibility(View.GONE);
                button2.setVisibility(View.GONE);
                button3.setVisibility(View.GONE);
                button4.setVisibility(View.GONE);
                button5.setVisibility(View.GONE);
                button6.setVisibility(View.GONE);
                button7.setVisibility(View.GONE);
                button8.setVisibility(View.GONE);
                button9.setVisibility(View.GONE);
                button10.setVisibility(View.GONE);
                button11.setVisibility(View.GONE);
                button12.setVisibility(View.GONE);
                button13.setVisibility(View.GONE);
                button14.setVisibility(View.GONE);
                button15.setVisibility(View.GONE);
                button16.setVisibility(View.GONE);
                button17.setVisibility(View.GONE);
                button18.setVisibility(View.GONE);
                button19.setVisibility(View.GONE);
                button20.setVisibility(View.GONE);
                button21.setVisibility(View.GONE);
                button22.setVisibility(View.GONE);
                button23.setVisibility(View.GONE);
                button24.setVisibility(View.GONE);
                button25.setVisibility(View.GONE);
                button26.setVisibility(View.GONE);
                button27.setVisibility(View.GONE);
                button28.setVisibility(View.GONE);
                button29.setVisibility(View.GONE);
                button30.setVisibility(View.GONE);
                button31.setVisibility(View.GONE);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 1:
                button0.setText(contactPoints[0]);
                button1.setVisibility(View.GONE);
                button2.setVisibility(View.GONE);
                button3.setVisibility(View.GONE);
                button4.setVisibility(View.GONE);
                button5.setVisibility(View.GONE);
                button6.setVisibility(View.GONE);
                button7.setVisibility(View.GONE);
                button8.setVisibility(View.GONE);
                button9.setVisibility(View.GONE);
                button10.setVisibility(View.GONE);
                button11.setVisibility(View.GONE);
                button12.setVisibility(View.GONE);
                button13.setVisibility(View.GONE);
                button14.setVisibility(View.GONE);
                button15.setVisibility(View.GONE);
                button16.setVisibility(View.GONE);
                button17.setVisibility(View.GONE);
                button18.setVisibility(View.GONE);
                button19.setVisibility(View.GONE);
                button20.setVisibility(View.GONE);
                button21.setVisibility(View.GONE);
                button22.setVisibility(View.GONE);
                button23.setVisibility(View.GONE);
                button24.setVisibility(View.GONE);
                button25.setVisibility(View.GONE);
                button26.setVisibility(View.GONE);
                button27.setVisibility(View.GONE);
                button28.setVisibility(View.GONE);
                button29.setVisibility(View.GONE);
                button30.setVisibility(View.GONE);
                button31.setVisibility(View.GONE);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 2:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setVisibility(View.GONE);
                button3.setVisibility(View.GONE);
                button4.setVisibility(View.GONE);
                button5.setVisibility(View.GONE);
                button6.setVisibility(View.GONE);
                button7.setVisibility(View.GONE);
                button8.setVisibility(View.GONE);
                button9.setVisibility(View.GONE);
                button10.setVisibility(View.GONE);
                button11.setVisibility(View.GONE);
                button12.setVisibility(View.GONE);
                button13.setVisibility(View.GONE);
                button14.setVisibility(View.GONE);
                button15.setVisibility(View.GONE);
                button16.setVisibility(View.GONE);
                button17.setVisibility(View.GONE);
                button18.setVisibility(View.GONE);
                button19.setVisibility(View.GONE);
                button20.setVisibility(View.GONE);
                button21.setVisibility(View.GONE);
                button22.setVisibility(View.GONE);
                button23.setVisibility(View.GONE);
                button24.setVisibility(View.GONE);
                button25.setVisibility(View.GONE);
                button26.setVisibility(View.GONE);
                button27.setVisibility(View.GONE);
                button28.setVisibility(View.GONE);
                button29.setVisibility(View.GONE);
                button30.setVisibility(View.GONE);
                button31.setVisibility(View.GONE);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 3:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setVisibility(View.GONE);
                button4.setVisibility(View.GONE);
                button5.setVisibility(View.GONE);
                button6.setVisibility(View.GONE);
                button7.setVisibility(View.GONE);
                button8.setVisibility(View.GONE);
                button9.setVisibility(View.GONE);
                button10.setVisibility(View.GONE);
                button11.setVisibility(View.GONE);
                button12.setVisibility(View.GONE);
                button13.setVisibility(View.GONE);
                button14.setVisibility(View.GONE);
                button15.setVisibility(View.GONE);
                button16.setVisibility(View.GONE);
                button17.setVisibility(View.GONE);
                button18.setVisibility(View.GONE);
                button19.setVisibility(View.GONE);
                button20.setVisibility(View.GONE);
                button21.setVisibility(View.GONE);
                button22.setVisibility(View.GONE);
                button23.setVisibility(View.GONE);
                button24.setVisibility(View.GONE);
                button25.setVisibility(View.GONE);
                button26.setVisibility(View.GONE);
                button27.setVisibility(View.GONE);
                button28.setVisibility(View.GONE);
                button29.setVisibility(View.GONE);
                button30.setVisibility(View.GONE);
                button31.setVisibility(View.GONE);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 4:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setText(contactPoints[3]);
                button4.setVisibility(View.GONE);
                button5.setVisibility(View.GONE);
                button6.setVisibility(View.GONE);
                button7.setVisibility(View.GONE);
                button8.setVisibility(View.GONE);
                button9.setVisibility(View.GONE);
                button10.setVisibility(View.GONE);
                button11.setVisibility(View.GONE);
                button12.setVisibility(View.GONE);
                button13.setVisibility(View.GONE);
                button14.setVisibility(View.GONE);
                button15.setVisibility(View.GONE);
                button16.setVisibility(View.GONE);
                button17.setVisibility(View.GONE);
                button18.setVisibility(View.GONE);
                button19.setVisibility(View.GONE);
                button20.setVisibility(View.GONE);
                button21.setVisibility(View.GONE);
                button22.setVisibility(View.GONE);
                button23.setVisibility(View.GONE);
                button24.setVisibility(View.GONE);
                button25.setVisibility(View.GONE);
                button26.setVisibility(View.GONE);
                button27.setVisibility(View.GONE);
                button28.setVisibility(View.GONE);
                button29.setVisibility(View.GONE);
                button30.setVisibility(View.GONE);
                button31.setVisibility(View.GONE);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 5:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setText(contactPoints[3]);
                button4.setText(contactPoints[4]);
                button5.setVisibility(View.GONE);
                button6.setVisibility(View.GONE);
                button7.setVisibility(View.GONE);
                button8.setVisibility(View.GONE);
                button9.setVisibility(View.GONE);
                button10.setVisibility(View.GONE);
                button11.setVisibility(View.GONE);
                button12.setVisibility(View.GONE);
                button13.setVisibility(View.GONE);
                button14.setVisibility(View.GONE);
                button15.setVisibility(View.GONE);
                button16.setVisibility(View.GONE);
                button17.setVisibility(View.GONE);
                button18.setVisibility(View.GONE);
                button19.setVisibility(View.GONE);
                button20.setVisibility(View.GONE);
                button21.setVisibility(View.GONE);
                button22.setVisibility(View.GONE);
                button23.setVisibility(View.GONE);
                button24.setVisibility(View.GONE);
                button25.setVisibility(View.GONE);
                button26.setVisibility(View.GONE);
                button27.setVisibility(View.GONE);
                button28.setVisibility(View.GONE);
                button29.setVisibility(View.GONE);
                button30.setVisibility(View.GONE);
                button31.setVisibility(View.GONE);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 6:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setText(contactPoints[3]);
                button4.setText(contactPoints[4]);
                button5.setText(contactPoints[5]);
                button6.setVisibility(View.GONE);
                button7.setVisibility(View.GONE);
                button8.setVisibility(View.GONE);
                button9.setVisibility(View.GONE);
                button10.setVisibility(View.GONE);
                button11.setVisibility(View.GONE);
                button12.setVisibility(View.GONE);
                button13.setVisibility(View.GONE);
                button14.setVisibility(View.GONE);
                button15.setVisibility(View.GONE);
                button16.setVisibility(View.GONE);
                button17.setVisibility(View.GONE);
                button18.setVisibility(View.GONE);
                button19.setVisibility(View.GONE);
                button20.setVisibility(View.GONE);
                button21.setVisibility(View.GONE);
                button22.setVisibility(View.GONE);
                button23.setVisibility(View.GONE);
                button24.setVisibility(View.GONE);
                button25.setVisibility(View.GONE);
                button26.setVisibility(View.GONE);
                button27.setVisibility(View.GONE);
                button28.setVisibility(View.GONE);
                button29.setVisibility(View.GONE);
                button30.setVisibility(View.GONE);
                button31.setVisibility(View.GONE);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 7:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setText(contactPoints[3]);
                button4.setText(contactPoints[4]);
                button5.setText(contactPoints[5]);
                button6.setText(contactPoints[6]);
                button7.setVisibility(View.GONE);
                button8.setVisibility(View.GONE);
                button9.setVisibility(View.GONE);
                button10.setVisibility(View.GONE);
                button11.setVisibility(View.GONE);
                button12.setVisibility(View.GONE);
                button13.setVisibility(View.GONE);
                button14.setVisibility(View.GONE);
                button15.setVisibility(View.GONE);
                button16.setVisibility(View.GONE);
                button17.setVisibility(View.GONE);
                button18.setVisibility(View.GONE);
                button19.setVisibility(View.GONE);
                button20.setVisibility(View.GONE);
                button21.setVisibility(View.GONE);
                button22.setVisibility(View.GONE);
                button23.setVisibility(View.GONE);
                button24.setVisibility(View.GONE);
                button25.setVisibility(View.GONE);
                button26.setVisibility(View.GONE);
                button27.setVisibility(View.GONE);
                button28.setVisibility(View.GONE);
                button29.setVisibility(View.GONE);
                button30.setVisibility(View.GONE);
                button31.setVisibility(View.GONE);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 8:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setText(contactPoints[3]);
                button4.setText(contactPoints[4]);
                button5.setText(contactPoints[5]);
                button6.setText(contactPoints[6]);
                button7.setText(contactPoints[7]);
                button8.setVisibility(View.GONE);
                button9.setVisibility(View.GONE);
                button10.setVisibility(View.GONE);
                button11.setVisibility(View.GONE);
                button12.setVisibility(View.GONE);
                button13.setVisibility(View.GONE);
                button14.setVisibility(View.GONE);
                button15.setVisibility(View.GONE);
                button16.setVisibility(View.GONE);
                button17.setVisibility(View.GONE);
                button18.setVisibility(View.GONE);
                button19.setVisibility(View.GONE);
                button20.setVisibility(View.GONE);
                button21.setVisibility(View.GONE);
                button22.setVisibility(View.GONE);
                button23.setVisibility(View.GONE);
                button24.setVisibility(View.GONE);
                button25.setVisibility(View.GONE);
                button26.setVisibility(View.GONE);
                button27.setVisibility(View.GONE);
                button28.setVisibility(View.GONE);
                button29.setVisibility(View.GONE);
                button30.setVisibility(View.GONE);
                button31.setVisibility(View.GONE);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 9:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setText(contactPoints[3]);
                button4.setText(contactPoints[4]);
                button5.setText(contactPoints[5]);
                button6.setText(contactPoints[6]);
                button7.setText(contactPoints[7]);
                button8.setText(contactPoints[8]);
                button9.setVisibility(View.GONE);
                button10.setVisibility(View.GONE);
                button11.setVisibility(View.GONE);
                button12.setVisibility(View.GONE);
                button13.setVisibility(View.GONE);
                button14.setVisibility(View.GONE);
                button15.setVisibility(View.GONE);
                button16.setVisibility(View.GONE);
                button17.setVisibility(View.GONE);
                button18.setVisibility(View.GONE);
                button19.setVisibility(View.GONE);
                button20.setVisibility(View.GONE);
                button21.setVisibility(View.GONE);
                button22.setVisibility(View.GONE);
                button23.setVisibility(View.GONE);
                button24.setVisibility(View.GONE);
                button25.setVisibility(View.GONE);
                button26.setVisibility(View.GONE);
                button27.setVisibility(View.GONE);
                button28.setVisibility(View.GONE);
                button29.setVisibility(View.GONE);
                button30.setVisibility(View.GONE);
                button31.setVisibility(View.GONE);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 10:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setText(contactPoints[3]);
                button4.setText(contactPoints[4]);
                button5.setText(contactPoints[5]);
                button6.setText(contactPoints[6]);
                button7.setText(contactPoints[7]);
                button8.setText(contactPoints[8]);
                button9.setText(contactPoints[9]);
                button10.setVisibility(View.GONE);
                button11.setVisibility(View.GONE);
                button12.setVisibility(View.GONE);
                button13.setVisibility(View.GONE);
                button14.setVisibility(View.GONE);
                button15.setVisibility(View.GONE);
                button16.setVisibility(View.GONE);
                button17.setVisibility(View.GONE);
                button18.setVisibility(View.GONE);
                button19.setVisibility(View.GONE);
                button20.setVisibility(View.GONE);
                button21.setVisibility(View.GONE);
                button22.setVisibility(View.GONE);
                button23.setVisibility(View.GONE);
                button24.setVisibility(View.GONE);
                button25.setVisibility(View.GONE);
                button26.setVisibility(View.GONE);
                button27.setVisibility(View.GONE);
                button28.setVisibility(View.GONE);
                button29.setVisibility(View.GONE);
                button30.setVisibility(View.GONE);
                button31.setVisibility(View.GONE);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 11:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setText(contactPoints[3]);
                button4.setText(contactPoints[4]);
                button5.setText(contactPoints[5]);
                button6.setText(contactPoints[6]);
                button7.setText(contactPoints[7]);
                button8.setText(contactPoints[8]);
                button9.setText(contactPoints[9]);
                button10.setText(contactPoints[10]);
                button11.setVisibility(View.GONE);
                button12.setVisibility(View.GONE);
                button13.setVisibility(View.GONE);
                button14.setVisibility(View.GONE);
                button15.setVisibility(View.GONE);
                button16.setVisibility(View.GONE);
                button17.setVisibility(View.GONE);
                button18.setVisibility(View.GONE);
                button19.setVisibility(View.GONE);
                button20.setVisibility(View.GONE);
                button21.setVisibility(View.GONE);
                button22.setVisibility(View.GONE);
                button23.setVisibility(View.GONE);
                button24.setVisibility(View.GONE);
                button25.setVisibility(View.GONE);
                button26.setVisibility(View.GONE);
                button27.setVisibility(View.GONE);
                button28.setVisibility(View.GONE);
                button29.setVisibility(View.GONE);
                button30.setVisibility(View.GONE);
                button31.setVisibility(View.GONE);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 12:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setText(contactPoints[3]);
                button4.setText(contactPoints[4]);
                button5.setText(contactPoints[5]);
                button6.setText(contactPoints[6]);
                button7.setText(contactPoints[7]);
                button8.setText(contactPoints[8]);
                button9.setText(contactPoints[9]);
                button10.setText(contactPoints[10]);
                button11.setText(contactPoints[11]);
                button12.setVisibility(View.GONE);
                button13.setVisibility(View.GONE);
                button14.setVisibility(View.GONE);
                button15.setVisibility(View.GONE);
                button16.setVisibility(View.GONE);
                button17.setVisibility(View.GONE);
                button18.setVisibility(View.GONE);
                button19.setVisibility(View.GONE);
                button20.setVisibility(View.GONE);
                button21.setVisibility(View.GONE);
                button22.setVisibility(View.GONE);
                button23.setVisibility(View.GONE);
                button24.setVisibility(View.GONE);
                button25.setVisibility(View.GONE);
                button26.setVisibility(View.GONE);
                button27.setVisibility(View.GONE);
                button28.setVisibility(View.GONE);
                button29.setVisibility(View.GONE);
                button30.setVisibility(View.GONE);
                button31.setVisibility(View.GONE);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 13:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setText(contactPoints[3]);
                button4.setText(contactPoints[4]);
                button5.setText(contactPoints[5]);
                button6.setText(contactPoints[6]);
                button7.setText(contactPoints[7]);
                button8.setText(contactPoints[8]);
                button9.setText(contactPoints[9]);
                button10.setText(contactPoints[10]);
                button11.setText(contactPoints[11]);
                button12.setText(contactPoints[12]);
                button13.setVisibility(View.GONE);
                button14.setVisibility(View.GONE);
                button15.setVisibility(View.GONE);
                button16.setVisibility(View.GONE);
                button17.setVisibility(View.GONE);
                button18.setVisibility(View.GONE);
                button19.setVisibility(View.GONE);
                button20.setVisibility(View.GONE);
                button21.setVisibility(View.GONE);
                button22.setVisibility(View.GONE);
                button23.setVisibility(View.GONE);
                button24.setVisibility(View.GONE);
                button25.setVisibility(View.GONE);
                button26.setVisibility(View.GONE);
                button27.setVisibility(View.GONE);
                button28.setVisibility(View.GONE);
                button29.setVisibility(View.GONE);
                button30.setVisibility(View.GONE);
                button31.setVisibility(View.GONE);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 14:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setText(contactPoints[3]);
                button4.setText(contactPoints[4]);
                button5.setText(contactPoints[5]);
                button6.setText(contactPoints[6]);
                button7.setText(contactPoints[7]);
                button8.setText(contactPoints[8]);
                button9.setText(contactPoints[9]);
                button10.setText(contactPoints[10]);
                button11.setText(contactPoints[11]);
                button12.setText(contactPoints[12]);
                button13.setText(contactPoints[13]);
                button14.setVisibility(View.GONE);
                button15.setVisibility(View.GONE);
                button16.setVisibility(View.GONE);
                button17.setVisibility(View.GONE);
                button18.setVisibility(View.GONE);
                button19.setVisibility(View.GONE);
                button20.setVisibility(View.GONE);
                button21.setVisibility(View.GONE);
                button22.setVisibility(View.GONE);
                button23.setVisibility(View.GONE);
                button24.setVisibility(View.GONE);
                button25.setVisibility(View.GONE);
                button26.setVisibility(View.GONE);
                button27.setVisibility(View.GONE);
                button28.setVisibility(View.GONE);
                button29.setVisibility(View.GONE);
                button30.setVisibility(View.GONE);
                button31.setVisibility(View.GONE);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 15:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setText(contactPoints[3]);
                button4.setText(contactPoints[4]);
                button5.setText(contactPoints[5]);
                button6.setText(contactPoints[6]);
                button7.setText(contactPoints[7]);
                button8.setText(contactPoints[8]);
                button9.setText(contactPoints[9]);
                button10.setText(contactPoints[10]);
                button11.setText(contactPoints[11]);
                button12.setText(contactPoints[12]);
                button13.setText(contactPoints[13]);
                button14.setText(contactPoints[14]);
                button15.setVisibility(View.GONE);
                button16.setVisibility(View.GONE);
                button17.setVisibility(View.GONE);
                button18.setVisibility(View.GONE);
                button19.setVisibility(View.GONE);
                button20.setVisibility(View.GONE);
                button21.setVisibility(View.GONE);
                button22.setVisibility(View.GONE);
                button23.setVisibility(View.GONE);
                button24.setVisibility(View.GONE);
                button25.setVisibility(View.GONE);
                button26.setVisibility(View.GONE);
                button27.setVisibility(View.GONE);
                button28.setVisibility(View.GONE);
                button29.setVisibility(View.GONE);
                button30.setVisibility(View.GONE);
                button31.setVisibility(View.GONE);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 16:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setText(contactPoints[3]);
                button4.setText(contactPoints[4]);
                button5.setText(contactPoints[5]);
                button6.setText(contactPoints[6]);
                button7.setText(contactPoints[7]);
                button8.setText(contactPoints[8]);
                button9.setText(contactPoints[9]);
                button10.setText(contactPoints[10]);
                button11.setText(contactPoints[11]);
                button12.setText(contactPoints[12]);
                button13.setText(contactPoints[13]);
                button14.setText(contactPoints[14]);
                button15.setText(contactPoints[15]);
                button16.setVisibility(View.GONE);
                button17.setVisibility(View.GONE);
                button18.setVisibility(View.GONE);
                button19.setVisibility(View.GONE);
                button20.setVisibility(View.GONE);
                button21.setVisibility(View.GONE);
                button22.setVisibility(View.GONE);
                button23.setVisibility(View.GONE);
                button24.setVisibility(View.GONE);
                button25.setVisibility(View.GONE);
                button26.setVisibility(View.GONE);
                button27.setVisibility(View.GONE);
                button28.setVisibility(View.GONE);
                button29.setVisibility(View.GONE);
                button30.setVisibility(View.GONE);
                button31.setVisibility(View.GONE);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 17:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setText(contactPoints[3]);
                button4.setText(contactPoints[4]);
                button5.setText(contactPoints[5]);
                button6.setText(contactPoints[6]);
                button7.setText(contactPoints[7]);
                button8.setText(contactPoints[8]);
                button9.setText(contactPoints[9]);
                button10.setText(contactPoints[10]);
                button11.setText(contactPoints[11]);
                button12.setText(contactPoints[12]);
                button13.setText(contactPoints[13]);
                button14.setText(contactPoints[14]);
                button15.setText(contactPoints[15]);
                button16.setText(contactPoints[16]);
                button17.setVisibility(View.GONE);
                button18.setVisibility(View.GONE);
                button19.setVisibility(View.GONE);
                button20.setVisibility(View.GONE);
                button21.setVisibility(View.GONE);
                button22.setVisibility(View.GONE);
                button23.setVisibility(View.GONE);
                button24.setVisibility(View.GONE);
                button25.setVisibility(View.GONE);
                button26.setVisibility(View.GONE);
                button27.setVisibility(View.GONE);
                button28.setVisibility(View.GONE);
                button29.setVisibility(View.GONE);
                button30.setVisibility(View.GONE);
                button31.setVisibility(View.GONE);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 18:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setText(contactPoints[3]);
                button4.setText(contactPoints[4]);
                button5.setText(contactPoints[5]);
                button6.setText(contactPoints[6]);
                button7.setText(contactPoints[7]);
                button8.setText(contactPoints[8]);
                button9.setText(contactPoints[9]);
                button10.setText(contactPoints[10]);
                button11.setText(contactPoints[11]);
                button12.setText(contactPoints[12]);
                button13.setText(contactPoints[13]);
                button14.setText(contactPoints[14]);
                button15.setText(contactPoints[15]);
                button16.setText(contactPoints[16]);
                button17.setText(contactPoints[17]);
                button18.setVisibility(View.GONE);
                button19.setVisibility(View.GONE);
                button20.setVisibility(View.GONE);
                button21.setVisibility(View.GONE);
                button22.setVisibility(View.GONE);
                button23.setVisibility(View.GONE);
                button24.setVisibility(View.GONE);
                button25.setVisibility(View.GONE);
                button26.setVisibility(View.GONE);
                button27.setVisibility(View.GONE);
                button28.setVisibility(View.GONE);
                button29.setVisibility(View.GONE);
                button30.setVisibility(View.GONE);
                button31.setVisibility(View.GONE);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 19:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setText(contactPoints[3]);
                button4.setText(contactPoints[4]);
                button5.setText(contactPoints[5]);
                button6.setText(contactPoints[6]);
                button7.setText(contactPoints[7]);
                button8.setText(contactPoints[8]);
                button9.setText(contactPoints[9]);
                button10.setText(contactPoints[10]);
                button11.setText(contactPoints[11]);
                button12.setText(contactPoints[12]);
                button13.setText(contactPoints[13]);
                button14.setText(contactPoints[14]);
                button15.setText(contactPoints[15]);
                button16.setText(contactPoints[16]);
                button17.setText(contactPoints[17]);
                button18.setText(contactPoints[18]);
                button19.setVisibility(View.GONE);
                button20.setVisibility(View.GONE);
                button21.setVisibility(View.GONE);
                button22.setVisibility(View.GONE);
                button23.setVisibility(View.GONE);
                button24.setVisibility(View.GONE);
                button25.setVisibility(View.GONE);
                button26.setVisibility(View.GONE);
                button27.setVisibility(View.GONE);
                button28.setVisibility(View.GONE);
                button29.setVisibility(View.GONE);
                button30.setVisibility(View.GONE);
                button31.setVisibility(View.GONE);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 20:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setText(contactPoints[3]);
                button4.setText(contactPoints[4]);
                button5.setText(contactPoints[5]);
                button6.setText(contactPoints[6]);
                button7.setText(contactPoints[7]);
                button8.setText(contactPoints[8]);
                button9.setText(contactPoints[9]);
                button10.setText(contactPoints[10]);
                button11.setText(contactPoints[11]);
                button12.setText(contactPoints[12]);
                button13.setText(contactPoints[13]);
                button14.setText(contactPoints[14]);
                button15.setText(contactPoints[15]);
                button16.setText(contactPoints[16]);
                button17.setText(contactPoints[17]);
                button18.setText(contactPoints[18]);
                button19.setText(contactPoints[19]);
                button20.setVisibility(View.GONE);
                button21.setVisibility(View.GONE);
                button22.setVisibility(View.GONE);
                button23.setVisibility(View.GONE);
                button24.setVisibility(View.GONE);
                button25.setVisibility(View.GONE);
                button26.setVisibility(View.GONE);
                button27.setVisibility(View.GONE);
                button28.setVisibility(View.GONE);
                button29.setVisibility(View.GONE);
                button30.setVisibility(View.GONE);
                button31.setVisibility(View.GONE);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 21:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setText(contactPoints[3]);
                button4.setText(contactPoints[4]);
                button5.setText(contactPoints[5]);
                button6.setText(contactPoints[6]);
                button7.setText(contactPoints[7]);
                button8.setText(contactPoints[8]);
                button9.setText(contactPoints[9]);
                button10.setText(contactPoints[10]);
                button11.setText(contactPoints[11]);
                button12.setText(contactPoints[12]);
                button13.setText(contactPoints[13]);
                button14.setText(contactPoints[14]);
                button15.setText(contactPoints[15]);
                button16.setText(contactPoints[16]);
                button17.setText(contactPoints[17]);
                button18.setText(contactPoints[18]);
                button19.setText(contactPoints[19]);
                button20.setText(contactPoints[20]);
                button21.setVisibility(View.GONE);
                button22.setVisibility(View.GONE);
                button23.setVisibility(View.GONE);
                button24.setVisibility(View.GONE);
                button25.setVisibility(View.GONE);
                button26.setVisibility(View.GONE);
                button27.setVisibility(View.GONE);
                button28.setVisibility(View.GONE);
                button29.setVisibility(View.GONE);
                button30.setVisibility(View.GONE);
                button31.setVisibility(View.GONE);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 22:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setText(contactPoints[3]);
                button4.setText(contactPoints[4]);
                button5.setText(contactPoints[5]);
                button6.setText(contactPoints[6]);
                button7.setText(contactPoints[7]);
                button8.setText(contactPoints[8]);
                button9.setText(contactPoints[9]);
                button10.setText(contactPoints[10]);
                button11.setText(contactPoints[11]);
                button12.setText(contactPoints[12]);
                button13.setText(contactPoints[13]);
                button14.setText(contactPoints[14]);
                button15.setText(contactPoints[15]);
                button16.setText(contactPoints[16]);
                button17.setText(contactPoints[17]);
                button18.setText(contactPoints[18]);
                button19.setText(contactPoints[19]);
                button20.setText(contactPoints[20]);
                button21.setText(contactPoints[21]);
                button22.setVisibility(View.GONE);
                button23.setVisibility(View.GONE);
                button24.setVisibility(View.GONE);
                button25.setVisibility(View.GONE);
                button26.setVisibility(View.GONE);
                button27.setVisibility(View.GONE);
                button28.setVisibility(View.GONE);
                button29.setVisibility(View.GONE);
                button30.setVisibility(View.GONE);
                button31.setVisibility(View.GONE);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 23:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setText(contactPoints[3]);
                button4.setText(contactPoints[4]);
                button5.setText(contactPoints[5]);
                button6.setText(contactPoints[6]);
                button7.setText(contactPoints[7]);
                button8.setText(contactPoints[8]);
                button9.setText(contactPoints[9]);
                button10.setText(contactPoints[10]);
                button11.setText(contactPoints[11]);
                button12.setText(contactPoints[12]);
                button13.setText(contactPoints[13]);
                button14.setText(contactPoints[14]);
                button15.setText(contactPoints[15]);
                button16.setText(contactPoints[16]);
                button17.setText(contactPoints[17]);
                button18.setText(contactPoints[18]);
                button19.setText(contactPoints[19]);
                button20.setText(contactPoints[20]);
                button21.setText(contactPoints[21]);
                button22.setText(contactPoints[22]);
                button23.setVisibility(View.GONE);
                button24.setVisibility(View.GONE);
                button25.setVisibility(View.GONE);
                button26.setVisibility(View.GONE);
                button27.setVisibility(View.GONE);
                button28.setVisibility(View.GONE);
                button29.setVisibility(View.GONE);
                button30.setVisibility(View.GONE);
                button31.setVisibility(View.GONE);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 24:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setText(contactPoints[3]);
                button4.setText(contactPoints[4]);
                button5.setText(contactPoints[5]);
                button6.setText(contactPoints[6]);
                button7.setText(contactPoints[7]);
                button8.setText(contactPoints[8]);
                button9.setText(contactPoints[9]);
                button10.setText(contactPoints[10]);
                button11.setText(contactPoints[11]);
                button12.setText(contactPoints[12]);
                button13.setText(contactPoints[13]);
                button14.setText(contactPoints[14]);
                button15.setText(contactPoints[15]);
                button16.setText(contactPoints[16]);
                button17.setText(contactPoints[17]);
                button18.setText(contactPoints[18]);
                button19.setText(contactPoints[19]);
                button20.setText(contactPoints[20]);
                button21.setText(contactPoints[21]);
                button22.setText(contactPoints[22]);
                button23.setText(contactPoints[23]);
                button24.setVisibility(View.GONE);
                button25.setVisibility(View.GONE);
                button26.setVisibility(View.GONE);
                button27.setVisibility(View.GONE);
                button28.setVisibility(View.GONE);
                button29.setVisibility(View.GONE);
                button30.setVisibility(View.GONE);
                button31.setVisibility(View.GONE);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 25:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setText(contactPoints[3]);
                button4.setText(contactPoints[4]);
                button5.setText(contactPoints[5]);
                button6.setText(contactPoints[6]);
                button7.setText(contactPoints[7]);
                button8.setText(contactPoints[8]);
                button9.setText(contactPoints[9]);
                button10.setText(contactPoints[10]);
                button11.setText(contactPoints[11]);
                button12.setText(contactPoints[12]);
                button13.setText(contactPoints[13]);
                button14.setText(contactPoints[14]);
                button15.setText(contactPoints[15]);
                button16.setText(contactPoints[16]);
                button17.setText(contactPoints[17]);
                button18.setText(contactPoints[18]);
                button19.setText(contactPoints[19]);
                button20.setText(contactPoints[20]);
                button21.setText(contactPoints[21]);
                button22.setText(contactPoints[22]);
                button23.setText(contactPoints[23]);
                button24.setText(contactPoints[24]);
                button25.setVisibility(View.GONE);
                button26.setVisibility(View.GONE);
                button27.setVisibility(View.GONE);
                button28.setVisibility(View.GONE);
                button29.setVisibility(View.GONE);
                button30.setVisibility(View.GONE);
                button31.setVisibility(View.GONE);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 26:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setText(contactPoints[3]);
                button4.setText(contactPoints[4]);
                button5.setText(contactPoints[5]);
                button6.setText(contactPoints[6]);
                button7.setText(contactPoints[7]);
                button8.setText(contactPoints[8]);
                button9.setText(contactPoints[9]);
                button10.setText(contactPoints[10]);
                button11.setText(contactPoints[11]);
                button12.setText(contactPoints[12]);
                button13.setText(contactPoints[13]);
                button14.setText(contactPoints[14]);
                button15.setText(contactPoints[15]);
                button16.setText(contactPoints[16]);
                button17.setText(contactPoints[17]);
                button18.setText(contactPoints[18]);
                button19.setText(contactPoints[19]);
                button20.setText(contactPoints[20]);
                button21.setText(contactPoints[21]);
                button22.setText(contactPoints[22]);
                button23.setText(contactPoints[23]);
                button24.setText(contactPoints[24]);
                button25.setText(contactPoints[25]);
                button26.setVisibility(View.GONE);
                button27.setVisibility(View.GONE);
                button28.setVisibility(View.GONE);
                button29.setVisibility(View.GONE);
                button30.setVisibility(View.GONE);
                button31.setVisibility(View.GONE);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 27:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setText(contactPoints[3]);
                button4.setText(contactPoints[4]);
                button5.setText(contactPoints[5]);
                button6.setText(contactPoints[6]);
                button7.setText(contactPoints[7]);
                button8.setText(contactPoints[8]);
                button9.setText(contactPoints[9]);
                button10.setText(contactPoints[10]);
                button11.setText(contactPoints[11]);
                button12.setText(contactPoints[12]);
                button13.setText(contactPoints[13]);
                button14.setText(contactPoints[14]);
                button15.setText(contactPoints[15]);
                button16.setText(contactPoints[16]);
                button17.setText(contactPoints[17]);
                button18.setText(contactPoints[18]);
                button19.setText(contactPoints[19]);
                button20.setText(contactPoints[20]);
                button21.setText(contactPoints[21]);
                button22.setText(contactPoints[22]);
                button23.setText(contactPoints[23]);
                button24.setText(contactPoints[24]);
                button25.setText(contactPoints[25]);
                button26.setText(contactPoints[26]);
                button27.setVisibility(View.GONE);
                button28.setVisibility(View.GONE);
                button29.setVisibility(View.GONE);
                button30.setVisibility(View.GONE);
                button31.setVisibility(View.GONE);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 28:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setText(contactPoints[3]);
                button4.setText(contactPoints[4]);
                button5.setText(contactPoints[5]);
                button6.setText(contactPoints[6]);
                button7.setText(contactPoints[7]);
                button8.setText(contactPoints[8]);
                button9.setText(contactPoints[9]);
                button10.setText(contactPoints[10]);
                button11.setText(contactPoints[11]);
                button12.setText(contactPoints[12]);
                button13.setText(contactPoints[13]);
                button14.setText(contactPoints[14]);
                button15.setText(contactPoints[15]);
                button16.setText(contactPoints[16]);
                button17.setText(contactPoints[17]);
                button18.setText(contactPoints[18]);
                button19.setText(contactPoints[19]);
                button20.setText(contactPoints[20]);
                button21.setText(contactPoints[21]);
                button22.setText(contactPoints[22]);
                button23.setText(contactPoints[23]);
                button24.setText(contactPoints[24]);
                button25.setText(contactPoints[25]);
                button26.setText(contactPoints[26]);
                button27.setText(contactPoints[27]);
                button28.setVisibility(View.GONE);
                button29.setVisibility(View.GONE);
                button30.setVisibility(View.GONE);
                button31.setVisibility(View.GONE);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 29:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setText(contactPoints[3]);
                button4.setText(contactPoints[4]);
                button5.setText(contactPoints[5]);
                button6.setText(contactPoints[6]);
                button7.setText(contactPoints[7]);
                button8.setText(contactPoints[8]);
                button9.setText(contactPoints[9]);
                button10.setText(contactPoints[10]);
                button11.setText(contactPoints[11]);
                button12.setText(contactPoints[12]);
                button13.setText(contactPoints[13]);
                button14.setText(contactPoints[14]);
                button15.setText(contactPoints[15]);
                button16.setText(contactPoints[16]);
                button17.setText(contactPoints[17]);
                button18.setText(contactPoints[18]);
                button19.setText(contactPoints[19]);
                button20.setText(contactPoints[20]);
                button21.setText(contactPoints[21]);
                button22.setText(contactPoints[22]);
                button23.setText(contactPoints[23]);
                button24.setText(contactPoints[24]);
                button25.setText(contactPoints[25]);
                button26.setText(contactPoints[26]);
                button27.setText(contactPoints[27]);
                button28.setText(contactPoints[28]);
                button29.setVisibility(View.GONE);
                button30.setVisibility(View.GONE);
                button31.setVisibility(View.GONE);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 30:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setText(contactPoints[3]);
                button4.setText(contactPoints[4]);
                button5.setText(contactPoints[5]);
                button6.setText(contactPoints[6]);
                button7.setText(contactPoints[7]);
                button8.setText(contactPoints[8]);
                button9.setText(contactPoints[9]);
                button10.setText(contactPoints[10]);
                button11.setText(contactPoints[11]);
                button12.setText(contactPoints[12]);
                button13.setText(contactPoints[13]);
                button14.setText(contactPoints[14]);
                button15.setText(contactPoints[15]);
                button16.setText(contactPoints[16]);
                button17.setText(contactPoints[17]);
                button18.setText(contactPoints[18]);
                button19.setText(contactPoints[19]);
                button20.setText(contactPoints[20]);
                button21.setText(contactPoints[21]);
                button22.setText(contactPoints[22]);
                button23.setText(contactPoints[23]);
                button24.setText(contactPoints[24]);
                button25.setText(contactPoints[25]);
                button26.setText(contactPoints[26]);
                button27.setText(contactPoints[27]);
                button28.setText(contactPoints[28]);
                button29.setText(contactPoints[29]);
                button30.setVisibility(View.GONE);
                button31.setVisibility(View.GONE);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 31:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setText(contactPoints[3]);
                button4.setText(contactPoints[4]);
                button5.setText(contactPoints[5]);
                button6.setText(contactPoints[6]);
                button7.setText(contactPoints[7]);
                button8.setText(contactPoints[8]);
                button9.setText(contactPoints[9]);
                button10.setText(contactPoints[10]);
                button11.setText(contactPoints[11]);
                button12.setText(contactPoints[12]);
                button13.setText(contactPoints[13]);
                button14.setText(contactPoints[14]);
                button15.setText(contactPoints[15]);
                button16.setText(contactPoints[16]);
                button17.setText(contactPoints[17]);
                button18.setText(contactPoints[18]);
                button19.setText(contactPoints[19]);
                button20.setText(contactPoints[20]);
                button21.setText(contactPoints[21]);
                button22.setText(contactPoints[22]);
                button23.setText(contactPoints[23]);
                button24.setText(contactPoints[24]);
                button25.setText(contactPoints[25]);
                button26.setText(contactPoints[26]);
                button27.setText(contactPoints[27]);
                button28.setText(contactPoints[28]);
                button29.setText(contactPoints[29]);
                button30.setText(contactPoints[30]);
                button31.setVisibility(View.GONE);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 32:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setText(contactPoints[3]);
                button4.setText(contactPoints[4]);
                button5.setText(contactPoints[5]);
                button6.setText(contactPoints[6]);
                button7.setText(contactPoints[7]);
                button8.setText(contactPoints[8]);
                button9.setText(contactPoints[9]);
                button10.setText(contactPoints[10]);
                button11.setText(contactPoints[11]);
                button12.setText(contactPoints[12]);
                button13.setText(contactPoints[13]);
                button14.setText(contactPoints[14]);
                button15.setText(contactPoints[15]);
                button16.setText(contactPoints[16]);
                button17.setText(contactPoints[17]);
                button18.setText(contactPoints[18]);
                button19.setText(contactPoints[19]);
                button20.setText(contactPoints[20]);
                button21.setText(contactPoints[21]);
                button22.setText(contactPoints[22]);
                button23.setText(contactPoints[23]);
                button24.setText(contactPoints[24]);
                button25.setText(contactPoints[25]);
                button26.setText(contactPoints[26]);
                button27.setText(contactPoints[27]);
                button28.setText(contactPoints[28]);
                button29.setText(contactPoints[29]);
                button30.setText(contactPoints[30]);
                button31.setText(contactPoints[31]);
                button32.setVisibility(View.GONE);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 33:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setText(contactPoints[3]);
                button4.setText(contactPoints[4]);
                button5.setText(contactPoints[5]);
                button6.setText(contactPoints[6]);
                button7.setText(contactPoints[7]);
                button8.setText(contactPoints[8]);
                button9.setText(contactPoints[9]);
                button10.setText(contactPoints[10]);
                button11.setText(contactPoints[11]);
                button12.setText(contactPoints[12]);
                button13.setText(contactPoints[13]);
                button14.setText(contactPoints[14]);
                button15.setText(contactPoints[15]);
                button16.setText(contactPoints[16]);
                button17.setText(contactPoints[17]);
                button18.setText(contactPoints[18]);
                button19.setText(contactPoints[19]);
                button20.setText(contactPoints[20]);
                button21.setText(contactPoints[21]);
                button22.setText(contactPoints[22]);
                button23.setText(contactPoints[23]);
                button24.setText(contactPoints[24]);
                button25.setText(contactPoints[25]);
                button26.setText(contactPoints[26]);
                button27.setText(contactPoints[27]);
                button28.setText(contactPoints[28]);
                button29.setText(contactPoints[29]);
                button30.setText(contactPoints[30]);
                button31.setText(contactPoints[31]);
                button32.setText(contactPoints[32]);
                button33.setVisibility(View.GONE);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 34:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setText(contactPoints[3]);
                button4.setText(contactPoints[4]);
                button5.setText(contactPoints[5]);
                button6.setText(contactPoints[6]);
                button7.setText(contactPoints[7]);
                button8.setText(contactPoints[8]);
                button9.setText(contactPoints[9]);
                button10.setText(contactPoints[10]);
                button11.setText(contactPoints[11]);
                button12.setText(contactPoints[12]);
                button13.setText(contactPoints[13]);
                button14.setText(contactPoints[14]);
                button15.setText(contactPoints[15]);
                button16.setText(contactPoints[16]);
                button17.setText(contactPoints[17]);
                button18.setText(contactPoints[18]);
                button19.setText(contactPoints[19]);
                button20.setText(contactPoints[20]);
                button21.setText(contactPoints[21]);
                button22.setText(contactPoints[22]);
                button23.setText(contactPoints[23]);
                button24.setText(contactPoints[24]);
                button25.setText(contactPoints[25]);
                button26.setText(contactPoints[26]);
                button27.setText(contactPoints[27]);
                button28.setText(contactPoints[28]);
                button29.setText(contactPoints[29]);
                button30.setText(contactPoints[30]);
                button31.setText(contactPoints[31]);
                button32.setText(contactPoints[32]);
                button33.setText(contactPoints[33]);
                button34.setVisibility(View.GONE);
                button35.setVisibility(View.GONE);
                break;
            case 35:
                button0.setText(contactPoints[0]);
                button1.setText(contactPoints[1]);
                button2.setText(contactPoints[2]);
                button3.setText(contactPoints[3]);
                button4.setText(contactPoints[4]);
                button5.setText(contactPoints[5]);
                button6.setText(contactPoints[6]);
                button7.setText(contactPoints[7]);
                button8.setText(contactPoints[8]);
                button9.setText(contactPoints[9]);
                button10.setText(contactPoints[10]);
                button11.setText(contactPoints[11]);
                button12.setText(contactPoints[12]);
                button13.setText(contactPoints[13]);
                button14.setText(contactPoints[14]);
                button15.setText(contactPoints[15]);
                button16.setText(contactPoints[16]);
                button17.setText(contactPoints[17]);
                button18.setText(contactPoints[18]);
                button19.setText(contactPoints[19]);
                button20.setText(contactPoints[20]);
                button21.setText(contactPoints[21]);
                button22.setText(contactPoints[22]);
                button23.setText(contactPoints[23]);
                button24.setText(contactPoints[24]);
                button25.setText(contactPoints[25]);
                button26.setText(contactPoints[26]);
                button27.setText(contactPoints[27]);
                button28.setText(contactPoints[28]);
                button29.setText(contactPoints[29]);
                button30.setText(contactPoints[30]);
                button31.setText(contactPoints[31]);
                button32.setText(contactPoints[32]);
                button33.setText(contactPoints[33]);
                button34.setText(contactPoints[34]);
                button35.setVisibility(View.GONE);
                break;


        }
        printallids();
    }

//write red button code here


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button0:
                String contactArea = button0.getText().toString();
                Intent intent0 = new Intent(ContactArea.this, Submit.class);
                intent0.putExtra("contactArea", contactArea);
                intent0.putExtra("touchPoint", touchPoint);
                insertInto(Area, touchPoint, contactArea);

                startActivity(intent0);
                break;

            case R.id.button1:
                contactArea = button1.getText().toString();
                Intent intent1 = new Intent(ContactArea.this, Submit.class);
                intent1.putExtra("contactArea", contactArea);
                intent1.putExtra("touchPoint", touchPoint);
                insertInto(Area, touchPoint, contactArea);
                startActivity(intent1);
                break;

            case R.id.button2:
                contactArea = button2.getText().toString();
                Intent intent2 = new Intent(ContactArea.this, Submit.class);
                intent2.putExtra("contactArea", contactArea);
                intent2.putExtra("touchPoint", touchPoint);
                insertInto(Area, touchPoint, contactArea);
                startActivity(intent2);
                break;

            case R.id.button3:
                contactArea = button3.getText().toString();
                Intent intent3 = new Intent(ContactArea.this, Submit.class);
                intent3.putExtra("contactArea", contactArea);
                intent3.putExtra("touchPoint", touchPoint);
                insertInto(Area, touchPoint, contactArea);
                startActivity(intent3);
                break;

            case R.id.button4:
                contactArea = button4.getText().toString();
                Intent intent4 = new Intent(ContactArea.this, Submit.class);
                intent4.putExtra("contactArea", contactArea);
                intent4.putExtra("touchPoint", touchPoint);
                insertInto(Area, touchPoint, contactArea);
                startActivity(intent4);
                break;

            case R.id.button5:
                contactArea = button5.getText().toString();
                Intent intent5 = new Intent(ContactArea.this, Submit.class);
                intent5.putExtra("contactArea", contactArea);
                intent5.putExtra("touchPoint", touchPoint);
                insertInto(Area, touchPoint, contactArea);
                startActivity(intent5);
                break;

            case R.id.button6:
                contactArea = button6.getText().toString();
                Intent intent6 = new Intent(ContactArea.this, Submit.class);
                intent6.putExtra("contactArea", contactArea);
                intent6.putExtra("touchPoint", touchPoint);
                startActivity(intent6);
                break;

            case R.id.button7:
                contactArea = button7.getText().toString();
                Intent intent7 = new Intent(ContactArea.this, Submit.class);
                intent7.putExtra("contactArea", contactArea);
                intent7.putExtra("touchPoint", touchPoint);
                startActivity(intent7);
                break;

            case R.id.button8:
                contactArea = button8.getText().toString();
                Intent intent8 = new Intent(ContactArea.this, Submit.class);
                intent8.putExtra("contactArea", contactArea);
                intent8.putExtra("touchPoint", touchPoint);
                startActivity(intent8);
                break;

            case R.id.button9:
                contactArea = button9.getText().toString();
                Intent intent9 = new Intent(ContactArea.this, Submit.class);
                intent9.putExtra("contactArea", contactArea);
                intent9.putExtra("touchPoint", touchPoint);
                startActivity(intent9);
                break;

            case R.id.button10:
                contactArea = button10.getText().toString();
                Intent intent10 = new Intent(ContactArea.this, Submit.class);
                intent10.putExtra("contactArea", contactArea);
                intent10.putExtra("touchPoint", touchPoint);
                startActivity(intent10);
                break;

            case R.id.button11:
                contactArea = button11.getText().toString();
                Intent intent11 = new Intent(ContactArea.this, Submit.class);
                intent11.putExtra("contactArea", contactArea);
                intent11.putExtra("touchPoint", touchPoint);
                startActivity(intent11);
                break;

            case R.id.button12:
                contactArea = button12.getText().toString();
                Intent intent12 = new Intent(ContactArea.this, Submit.class);
                intent12.putExtra("contactArea", contactArea);
                intent12.putExtra("touchPoint", touchPoint);
                startActivity(intent12);
                break;

            case R.id.button13:
                contactArea = button13.getText().toString();
                Intent intent13 = new Intent(ContactArea.this, Submit.class);
                intent13.putExtra("contactArea", contactArea);
                intent13.putExtra("touchPoint", touchPoint);
                startActivity(intent13);
                break;

            case R.id.button14:
                contactArea = button14.getText().toString();
                Intent intent14 = new Intent(ContactArea.this, Submit.class);
                intent14.putExtra("contactArea", contactArea);
                intent14.putExtra("touchPoint", touchPoint);
                startActivity(intent14);
                break;

            case R.id.button15:
                contactArea = button15.getText().toString();
                Intent intent15 = new Intent(ContactArea.this, Submit.class);
                intent15.putExtra("contactArea", contactArea);
                intent15.putExtra("touchPoint", touchPoint);
                startActivity(intent15);
                break;

            case R.id.button16:
                contactArea = button16.getText().toString();
                Intent intent16 = new Intent(ContactArea.this, Submit.class);
                intent16.putExtra("contactArea", contactArea);
                intent16.putExtra("touchPoint", touchPoint);
                startActivity(intent16);
                break;

            case R.id.button17:
                contactArea = button17.getText().toString();
                Intent intent17 = new Intent(ContactArea.this, Submit.class);
                intent17.putExtra("contactArea", contactArea);
                intent17.putExtra("touchPoint", touchPoint);
                startActivity(intent17);
                break;

            case R.id.button18:
                contactArea = button18.getText().toString();
                Intent intent18 = new Intent(ContactArea.this, Submit.class);
                intent18.putExtra("contactArea", contactArea);
                intent18.putExtra("touchPoint", touchPoint);
                startActivity(intent18);
                break;

            case R.id.button19:
                contactArea = button19.getText().toString();
                Intent intent19 = new Intent(ContactArea.this, Submit.class);
                intent19.putExtra("contactArea", contactArea);
                intent19.putExtra("touchPoint", touchPoint);
                startActivity(intent19);
                break;

            case R.id.button20:
                contactArea = button20.getText().toString();
                Intent intent20 = new Intent(ContactArea.this, Submit.class);
                intent20.putExtra("contactArea", contactArea);
                intent20.putExtra("touchPoint", touchPoint);
                startActivity(intent20);
                break;

            case R.id.button21:
                contactArea = button21.getText().toString();
                Intent intent21 = new Intent(ContactArea.this, Submit.class);
                intent21.putExtra("contactArea", contactArea);
                intent21.putExtra("touchPoint", touchPoint);
                startActivity(intent21);
                break;

            case R.id.button22:
                contactArea = button22.getText().toString();
                Intent intent22 = new Intent(ContactArea.this, Submit.class);
                intent22.putExtra("contactArea", contactArea);
                intent22.putExtra("touchPoint", touchPoint);
                startActivity(intent22);
                break;

            case R.id.button23:
                contactArea = button23.getText().toString();
                Intent intent23 = new Intent(ContactArea.this, Submit.class);
                intent23.putExtra("contactArea", contactArea);
                intent23.putExtra("touchPoint", touchPoint);
                startActivity(intent23);
                break;

            case R.id.button24:
                contactArea = button24.getText().toString();
                Intent intent24 = new Intent(ContactArea.this, Submit.class);
                intent24.putExtra("contactArea", contactArea);
                intent24.putExtra("touchPoint", touchPoint);
                startActivity(intent24);
                break;

            case R.id.button25:
                contactArea = button25.getText().toString();
                Intent intent25 = new Intent(ContactArea.this, Submit.class);
                intent25.putExtra("contactArea", contactArea);
                intent25.putExtra("touchPoint", touchPoint);
                startActivity(intent25);
                break;

            case R.id.button26:
                contactArea = button26.getText().toString();
                Intent intent26 = new Intent(ContactArea.this, Submit.class);
                intent26.putExtra("contactArea", contactArea);
                intent26.putExtra("touchPoint", touchPoint);
                startActivity(intent26);
                break;

            case R.id.button27:
                contactArea = button27.getText().toString();
                Intent intent27 = new Intent(ContactArea.this, Submit.class);
                intent27.putExtra("contactArea", contactArea);
                intent27.putExtra("touchPoint", touchPoint);
                startActivity(intent27);
                break;

            case R.id.button28:
                contactArea = button28.getText().toString();
                Intent intent28 = new Intent(ContactArea.this, Submit.class);
                intent28.putExtra("contactArea", contactArea);
                intent28.putExtra("touchPoint", touchPoint);
                startActivity(intent28);
                break;

            case R.id.button29:
                contactArea = button29.getText().toString();
                Intent intent29 = new Intent(ContactArea.this, Submit.class);
                intent29.putExtra("contactArea", contactArea);
                intent29.putExtra("touchPoint", touchPoint);
                startActivity(intent29);
                break;

            case R.id.button30:
                contactArea = button30.getText().toString();
                Intent intent30 = new Intent(ContactArea.this, Submit.class);
                intent30.putExtra("contactArea", contactArea);
                intent30.putExtra("touchPoint", touchPoint);
                startActivity(intent30);
                break;

            case R.id.button31:
                contactArea = button31.getText().toString();
                Intent intent31 = new Intent(ContactArea.this, Submit.class);
                intent31.putExtra("contactArea", contactArea);
                intent31.putExtra("touchPoint", touchPoint);
                startActivity(intent31);
                break;

            case R.id.button32:
                contactArea = button32.getText().toString();
                Intent intent32 = new Intent(ContactArea.this, Submit.class);
                intent32.putExtra("contactArea", contactArea);
                intent32.putExtra("touchPoint", touchPoint);
                startActivity(intent32);
                break;

            case R.id.button33:
                contactArea = button33.getText().toString();
                Intent intent33 = new Intent(ContactArea.this, Submit.class);
                intent33.putExtra("contactArea", contactArea);
                intent33.putExtra("touchPoint", touchPoint);
                startActivity(intent33);
                break;

            case R.id.button34:
                contactArea = button34.getText().toString();
                Intent intent34 = new Intent(ContactArea.this, Submit.class);
                intent34.putExtra("contactArea", contactArea);
                intent34.putExtra("touchPoint", touchPoint);
                startActivity(intent34);
                break;

            case R.id.button35:
                contactArea = button35.getText().toString();
                Intent intent35 = new Intent(ContactArea.this, Submit.class);
                intent35.putExtra("contactArea", contactArea);
                intent35.putExtra("touchPoint", touchPoint);
                startActivity(intent35);
                break;
        }
    }

    public void insertInto(String area, String tp, String ca) {
        boolean insert = myDb.insertDate(area, tp, ca, "NO");


    }

//    public void updateButtonIndicator(String Area, String tp, String ca) {
//        Cursor cursor = myDb.getData2(Area, tp);
//        myDb.getData();
//        if (cursor.getCount() == 0)
//            Log.d("Database ", "No Data");
//        StringBuffer buffer = new StringBuffer();
//        int j = 0;
//        while (cursor.moveToNext()) {
//            buttonEnablerContactArea[j] = cursor.getString(2);
//            buttonEnableRed[j] = cursor.getString(3);
//            buffer.append("Area:" + cursor.getString(0) + "\n");
//            buffer.append("tp:" + cursor.getString(1) + "\n");
//            buffer.append("ca:" + cursor.getString(2) + "\n");
//            buffer.append("touch:" + cursor.getString(3) + "\n");
//            try{buffer.append("date:"+cursor.getString(4)+"\n");}catch (Exception e){
//                e.printStackTrace();
//            }
//            j++;
//        }
//        for (int i = 0; i < j; i++) {
//            Log.d("DatabaseData2", "" + buttonEnableRed[i] + "  " + buttonEnablerContactArea[i]);
//        }
//        rollOverButton();
//        Log.d("DatabaseData", buffer.toString());
//    }
    public void rollOverButton(){
        String  buttonText2 = null;
        for(int i=0;i<37;i++)
        switch (i) {

            case 1:
                buttonText2 = (String)button0.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                    if(buttonText2.equalsIgnoreCase(temp1)){
                        button0.setBackgroundColor(RED);
                    break;}}catch (Exception e){
                    }
                }break;
            case 2:
                buttonText2 = (String)button1.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button1.setBackgroundColor(RED);break;}}catch (Exception e){
                    }
                }break;
            case 3:
                buttonText2 = (String)button2.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        temp1 = contactArea[j].replaceAll("&","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll("&","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button2.setBackgroundColor(RED);break;}}catch (Exception e){
                    }
                }break;
            case 4:
                buttonText2 = (String)button3.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button3.setBackgroundColor(RED);break;}}catch (Exception e){
                    }
                }break;
            case 5:
                buttonText2 = (String)button4.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button4.setBackgroundColor(RED);break;}}catch (Exception e){
                    }
                }break;
            case 6:
                buttonText2 = (String)button5.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button5.setBackgroundColor(RED);break;}}catch (Exception e){
                    }
                }break;
            case 7:
                buttonText2 = (String)button6.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button6.setBackgroundColor(RED);}}catch (Exception e){
                    }
                }break;
            case 8:
                buttonText2 = (String)button7.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button7.setBackgroundColor(RED);break;}}catch (Exception e){
                    }
                }break;
            case 9:
                buttonText2 = (String)button8.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button8.setBackgroundColor(RED);break;}}catch (Exception e){
                    }
                }break;
            case 10:
                buttonText2 = (String)button9.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button9.setBackgroundColor(RED);break;}}catch (Exception e){
                    }
                }break;
            case 11:
                buttonText2 = (String)button10.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button10.setBackgroundColor(RED);break;}}catch (Exception e){
                    }
                }break;
            case 12:
                buttonText2 = (String)button11.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button11.setBackgroundColor(RED);break;}}catch (Exception e){
                    }
                }break;
            case 13:
                buttonText2 = (String)button12.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button12.setBackgroundColor(RED);break;}}catch (Exception e){
                    }
                }break;
            case 14:
                buttonText2 = (String)button13.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button13.setBackgroundColor(RED);}}catch (Exception e){
                    }
                }break;
            case 15:
                buttonText2 = (String)button14.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button14.setBackgroundColor(RED);}}catch (Exception e){
                    }
                }break;
            case 16:
                buttonText2 = (String)button15.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button15.setBackgroundColor(RED);}}catch (Exception e){
                    }
                }break;
            case 17:
                buttonText2 = (String)button16.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button16.setBackgroundColor(RED);}}catch (Exception e){
                    }
                }break;
            case 18:
                buttonText2 = (String)button17.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button17.setBackgroundColor(RED);}}catch (Exception e){
                    }
                }break;
            case 19:
                buttonText2 = (String)button18.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button18.setBackgroundColor(RED);}}catch (Exception e){
                    }
                }break;
            case 20:
                buttonText2 = (String)button19.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button19.setBackgroundColor(RED);}}catch (Exception e){
                    }
                }break;
            case 21:
                buttonText2 = (String)button20.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button20.setBackgroundColor(RED);}}catch (Exception e){
                    }
                }break;
            case 22:
                buttonText2 = (String)button21.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button21.setBackgroundColor(RED);}}catch (Exception e){
                    }
                }break;
            case 23:
                buttonText2 = (String)button22.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button22.setBackgroundColor(RED);}}catch (Exception e){
                    }
                }break;
            case 24:
                buttonText2 = (String)button23.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button23.setBackgroundColor(RED);}}catch (Exception e){
                    }
                }break;
            case 25:
                buttonText2 = (String)button24.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button24.setBackgroundColor(RED);}}catch (Exception e){
                    }
                }break;
            case 26:
                buttonText2 = (String)button25.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button25.setBackgroundColor(RED);}}catch (Exception e){
                    }
                }break;
            case 27:
                buttonText2 = (String)button26.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button26.setBackgroundColor(RED);}}catch (Exception e){
                    }
                }break;
            case 28:
                buttonText2 = (String)button27.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button27.setBackgroundColor(RED);}}catch (Exception e){
                    }
                }break;
            case 29:
                buttonText2 = (String)button28.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button28.setBackgroundColor(RED);}}catch (Exception e){
                    }
                }break;
            case 30:
                buttonText2 = (String)button29.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button29.setBackgroundColor(RED);}}catch (Exception e){
                    }
                }break;
            case 31:
                buttonText2 = (String)button30.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button30.setBackgroundColor(RED);}}catch (Exception e){
                    }
                }break;
            case 32:
                buttonText2 = (String)button31.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button31.setBackgroundColor(RED);}}catch (Exception e){
                    }
                }break;
            case 33:
                buttonText2 = (String)button32.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button32.setBackgroundColor(RED);}}catch (Exception e){
                    }
                }break;
            case 34:
                buttonText2 = (String)button33.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button33.setBackgroundColor(RED);}}catch (Exception e){
                    }
                }break;
            case 35:
                buttonText2 = (String)button34.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button34.setBackgroundColor(RED);}}catch (Exception e){
                    }
                }break;
            case 36:
                buttonText2 = (String)button35.getText();
                for(int j = 0;j<=length;j++){

                    try{String temp1 = contactArea[j].replaceAll(" ","");
                        buttonText2=buttonText2.replaceAll(" ","");
                        Log.d("DatabaseData222",""+buttonText2+"  "+temp1+"  inside");
                        if(buttonText2.equalsIgnoreCase(temp1)){
                            button35.setBackgroundColor(RED);}}catch (Exception e){
                    }
                }break;

        }
    }
                                                                                                                                                                                                                                                                                                        }


