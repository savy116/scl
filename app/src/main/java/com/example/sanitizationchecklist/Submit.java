package com.example.sanitizationchecklist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Submit extends AppCompatActivity {
    public double lat, longi;
    public LocationManager locationManager;
    public LocationListener locationListener = new MyLocationListener();
String touchPoint;
    String contactArea;
    String timing1;
    String timing2;
    String cleaingProcedure;
    String checkbutton;
    DataBaseHelper myDb;
    String Area,latcheck = "no";
    Editable remarks;
String [] contactAreas,cp,touchPoints,timing,inspectedBy;
TextView TouchPointTV,AreaTV,contactPointTV,cleaningProcedureTV;
EditText rem;
int touchpointId = 0,contactAreaId = 0,areaId = 0;
    TextView count;
    private boolean gps_enble = false;
    private boolean netword_enable = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        myDb = new DataBaseHelper(this);

        contactArea = getIntent().getStringExtra("contactArea");
        touchPoint = getIntent().getStringExtra("touchPoint");
        SharedPreferences pref=getApplicationContext().getSharedPreferences("MyPref",0);
        areaId = (pref.getInt("AreaId",0));
        SharedPreferences preferences=getApplicationContext().getSharedPreferences("MyPref",0);
        Area = preferences.getString("Area",null);
        touchPoints = getResources().getStringArray(R.array.TouchPoint);
        int flag = 0;
        contactAreaId = getContactArea(contactArea);
        for(int i = 0;i<touchPoints.length;i++){


//            Log.d("TouchCheck",""+touchPoint);
//            Log.d("TouchCheck",""+touchPoints[i]);


            if(touchPoint.equalsIgnoreCase(touchPoints[i])){
                flag = i+2;
                touchpointId = flag-1;
//                Log.d("TouchCheck",""+touchpointId);
                break;
            }

        }

        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        checkLocationPermission();
        getMyLocation();
        rem = findViewById(R.id.remarks);
        count = findViewById(R.id.count);
        rem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String s = rem.getText().toString();
                int l = s.length();
                String len = ""+l;
                String part2 = "/4000";
                count.setText(l+part2);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        switch (flag){
            case 1:
                break;
            case 2:
                contactAreas = getResources().getStringArray(R.array.tp2);
                cp =  getResources().getStringArray(R.array.tpcp2);
                timing = getResources().getStringArray(R.array.tpt2);
                timing1 = timing[0];timing2 = timing[1];
                break;

            case 3:
                contactAreas = getResources().getStringArray(R.array.tp3);
                cp =  getResources().getStringArray(R.array.tpcp3);
                timing = getResources().getStringArray(R.array.tpt3);
                timing1 = timing[0];timing2 = timing[1];
                break;

            case 4:
                contactAreas = getResources().getStringArray(R.array.tp4);
                cp =  getResources().getStringArray(R.array.tpcp4);
                timing = getResources().getStringArray(R.array.tpt4);
                timing1 = timing[0];timing2 = timing[1];
                break;

            case 5:
                contactAreas = getResources().getStringArray(R.array.tp5);
                cp =  getResources().getStringArray(R.array.tpcp5);
                timing = getResources().getStringArray(R.array.tpt5);
                timing1 = timing[0];timing2 = timing[1];
                break;

            case 6:
                contactAreas = getResources().getStringArray(R.array.tp6);
                cp =  getResources().getStringArray(R.array.tpcp6);
                timing = getResources().getStringArray(R.array.tpt6);
                timing1 = timing[0];timing2 = timing[1];
                break;

            case 7:
                contactAreas = getResources().getStringArray(R.array.tp7);
                cp =  getResources().getStringArray(R.array.tpcp7);
                timing = getResources().getStringArray(R.array.tpt7);
                timing1 = timing[0];timing2 = timing[1];
                break;

            case 8:
                contactAreas = getResources().getStringArray(R.array.tp8);
                cp =  getResources().getStringArray(R.array.tpcp8);
                timing = getResources().getStringArray(R.array.tpt8);
                timing1 = timing[0];timing2 = timing[1];
                break;

            case 9:
                contactAreas = getResources().getStringArray(R.array.tp9);
                cp =  getResources().getStringArray(R.array.tpcp9);
                timing = getResources().getStringArray(R.array.tpt9);
                timing1 = timing[0];timing2 = timing[1];
                break;

            case 10:
                contactAreas = getResources().getStringArray(R.array.tp10);
                cp =  getResources().getStringArray(R.array.tpcp10);
                timing = getResources().getStringArray(R.array.tpt10);
                timing1 = timing[0];timing2 = timing[1];
                break;

            case 11:
                contactAreas = getResources().getStringArray(R.array.tp11);
                cp =  getResources().getStringArray(R.array.tpcp11);
                timing = getResources().getStringArray(R.array.tpt11);
                timing1 = timing[0];timing2 = timing[1];
                break;

            case 12:
                contactAreas = getResources().getStringArray(R.array.tp12);
                cp =  getResources().getStringArray(R.array.tpcp12);
                timing = getResources().getStringArray(R.array.tpt12);
                timing1 = timing[0];timing2 = timing[1];
                break;

            case 13:
                contactAreas = getResources().getStringArray(R.array.tp13);
                cp =  getResources().getStringArray(R.array.tpcp13);
                timing = getResources().getStringArray(R.array.tpt13);
                timing1 = timing[0];timing2 = timing[1];
                break;

            case 14:
                contactAreas = getResources().getStringArray(R.array.tp14);
                cp =  getResources().getStringArray(R.array.tpcp14);
                timing = getResources().getStringArray(R.array.tpt14);
                timing1 = timing[0];timing2 = timing[1];
                break;

            case 15:
                contactAreas = getResources().getStringArray(R.array.tp15);
                cp =  getResources().getStringArray(R.array.tpcp15);
                timing = getResources().getStringArray(R.array.tpt15);
                timing1 = timing[0];timing2 = timing[1];
                break;

            case 16:
                contactAreas = getResources().getStringArray(R.array.tp16);
                cp =  getResources().getStringArray(R.array.tpcp16);
                timing = getResources().getStringArray(R.array.tpt16);
                timing1 = timing[0];timing2 = timing[1];
                break;

            case 17:
                contactAreas = getResources().getStringArray(R.array.tp17);
                cp =  getResources().getStringArray(R.array.tpcp17);
                timing = getResources().getStringArray(R.array.tpt17);
                timing1 = timing[0];timing2 = timing[1];
                break;

            case 18:
                contactAreas = getResources().getStringArray(R.array.tp18);
                cp =  getResources().getStringArray(R.array.tpcp18);
                timing = getResources().getStringArray(R.array.tpt18);
                timing1 = timing[0];timing2 = timing[1];
                break;

            case 19:
                contactAreas = getResources().getStringArray(R.array.tp19);
                cp =  getResources().getStringArray(R.array.tpcp19);
                timing = getResources().getStringArray(R.array.tpt19);
                timing1 = timing[0];timing2 = timing[1];
                break;

            case 20:
                contactAreas = getResources().getStringArray(R.array.tp20);
                cp =  getResources().getStringArray(R.array.tpcp20);
                timing = getResources().getStringArray(R.array.tpt20);
                timing1 = timing[0];timing2 = timing[1];
                break;

            case 21:
                contactAreas = getResources().getStringArray(R.array.tp21);
                cp =  getResources().getStringArray(R.array.tpcp21);
                timing = getResources().getStringArray(R.array.tpt21);
                timing1 = timing[0];timing2 = timing[1];
                break;

            case 22:
                contactAreas = getResources().getStringArray(R.array.tp22);
                cp =  getResources().getStringArray(R.array.tpcp22);
                timing = getResources().getStringArray(R.array.tpt22);
                timing1 = timing[0];timing2 = timing[1];
                break;

            case 23:
                contactAreas = getResources().getStringArray(R.array.tp23);
                cp =  getResources().getStringArray(R.array.tpcp23);
                timing = getResources().getStringArray(R.array.tpt23);
                timing1 = timing[0];timing2 = timing[1];
                break;

            case 24:
                contactAreas = getResources().getStringArray(R.array.tp24);
                cp =  getResources().getStringArray(R.array.tpcp24);
                timing = getResources().getStringArray(R.array.tpt24);
                timing1 = timing[0];timing2 = timing[1];
                break;



        }
//            contactAreas = getResources().getStringArray(R.array.tp2);
//            cp =  getResources().getStringArray(R.array.tpcp2);


        for(int i = 0;i<contactAreas.length;i++){

            if(contactArea.equalsIgnoreCase(contactAreas[i])){
                cleaingProcedure = cp[i];

            }
        }


//        Log.d("arrainge",""+touchPoint+" "+contactArea+" "+cleaingProcedure+" "+timing1+" "+timing2);
        Log.d("contactA",""+touchpointId+" "+contactAreaId);
        TouchPointTV = findViewById(R.id.TouchPoint);
        TouchPointTV.setText(touchPoint);
        cleaningProcedureTV = findViewById(R.id.cptv);
        cleaningProcedureTV.setText(cleaingProcedure);
        contactPointTV = findViewById(R.id.ContactArea);
        contactPointTV.setText(contactArea);
        AreaTV = findViewById(R.id.Area);
        AreaTV.setText(Area);
        updateDatabase(Area,touchPoint,contactArea);
        inspectedBy = getResources().getStringArray(R.array.inspectedBy);

        ArrayAdapter<String> adapter6 = new ArrayAdapter<String> (this,android.R.layout.simple_spinner_item,timing);
        ((Spinner)findViewById(R.id.fc_shift_time)).setAdapter(adapter6);

        ArrayAdapter<String> adapter7 = new ArrayAdapter<String> (this,android.R.layout.simple_spinner_item,inspectedBy);
        ((Spinner)findViewById(R.id.inspectedBySpinner)).setAdapter(adapter7);


        final Button button = (Button)findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remarks = rem.getText();
                if(checkbutton.equalsIgnoreCase("yes")||checkbutton.equalsIgnoreCase("no")){
////                Log.d("radio",checkbutton);
//
//                    postRequest();
//                    finish();
////                        Intent intent = new Intent(Submit.this,Monitor.class);
////                startActivity(intent);
                    if(lat==0.0){
                        Log.d("failed to ","grab location");
                    }

                    if(!latcheck.equals("yes")){
                        Toast.makeText(Submit.this,"Please Turn On The Location Service",Toast.LENGTH_SHORT).show();
                    }

                    if(latcheck.equals("yes")&&((lat==0.0)||(longi==0.0))) {

                        button.setEnabled(false);

                        Handler handler = new Handler();
                        Runnable r = new Runnable() {
                            public void run() {

//                                callSwitch();

                                if(lat==0){
                                    Toast.makeText(Submit.this,"Failed To grab loaction please wait",Toast.LENGTH_SHORT).show();

                                }button.setEnabled(true);
                            }
                        };
                        handler.postDelayed(r, 1500);


                    }else if(latcheck.equals("yes")&&lat!=0.0){
                        postRequest();
                        finish();
                    }
                }
                else{
                    Toast.makeText(Submit.this,"Please Select Yes or No",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public void getMyLocation() {
        try {
            gps_enble = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        } catch (Exception e) {

        }
        try {
            netword_enable = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        } catch (Exception e) {

        }
        if (!gps_enble || !netword_enable) {

            latcheck = "no";
        }
        if (gps_enble) {
            latcheck = "yes";
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        }
        if(netword_enable){
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);

        }


    }

    public void checkLocationPermission(){
        int location = ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION);
        int location2 = ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION);
        List<String> listPermission = new ArrayList<>();
        if(location != PackageManager.PERMISSION_GRANTED){
            listPermission.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }if (location2 != PackageManager.PERMISSION_GRANTED){
            listPermission.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        }if(!listPermission.isEmpty()){
            ActivityCompat.requestPermissions(this,listPermission.toArray(new String[listPermission.size()]),1);
        }


    }

    public void updateDatabase(String area,String tp,String ca){
        boolean updated = myDb.updateData(area,tp,ca,"updated");
        if(updated)
            Log.d("updated","Data is updated");
        else
            Log.d("Update","not updated");
    }

    public int getContactArea(String contactArea){
        String [] contactAreasID  = getResources().getStringArray(R.array.UNIQUECONTACTAREAS);
        int cid = 0;
        for(int i = 0;i<contactAreasID.length;i++){
            if(contactArea.equalsIgnoreCase(contactAreasID[i])) {
                cid = i + 1;
                break;
            }
        }
        return cid;

    }

    private void postRequest() {

        RequestQueue requestQueue = Volley.newRequestQueue(Submit.this);
        String URL = (new Parameters().returnParameter())+"InsertCheckList";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject obj = new JSONObject(response);
                    String webResponse = obj.getString("Insert Response");
                    Log.d("response",""+webResponse);
                    Toast.makeText(Submit.this,webResponse,Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("errorVoll",""+error);
                Toast.makeText(Submit.this,"Cannot Access Web Service",Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String,String> getParams(){

                Map<String,String> params = new HashMap<String, String>();
                params.put("areaId",""+areaId);
                params.put("tpid",""+touchpointId);
                params.put("caid",""+contactAreaId);
                params.put("remarks",""+remarks);
                params.put("entryBy","ADMIN FROM APP");
                params.put("score",checkbutton);
                params.put("entryByDesg","ADMIN");
                params.put("Latitude",""+lat);
                params.put("Longitude",""+longi);
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

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();



        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton:
                if (checked){
                    checkbutton = "YES";
                    rem.setVisibility(View.GONE);
                    count.setVisibility(View.GONE);
                }

                break;
            case R.id.radioButton2:
                if (checked){
                    checkbutton = "NO";
                    rem.setVisibility(View.VISIBLE);
                    count.setVisibility(View.VISIBLE);
                }

                break;
        }
    }

    class MyLocationListener implements LocationListener {

        @Override
        public void onLocationChanged(@NonNull Location location) {
            if (location != null) {
                locationManager.removeUpdates(locationListener);
                lat = location.getLatitude();
                longi = location.getLongitude();
                String slat = "" + location.getLatitude();
                String slongi = "" + location.getLongitude();



            }
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(@NonNull String provider) {

        }

        @Override
        public void onProviderDisabled(@NonNull String provider) {

        }
    }

}