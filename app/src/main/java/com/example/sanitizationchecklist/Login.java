package com.example.sanitizationchecklist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

public class Login extends AppCompatActivity {
    EditText ed1,ed2;

    String ldapVerify,desg,userid,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button = findViewById(R.id.loginbtn);

        SessionManager session = new SessionManager(this.getApplicationContext());
        session.logoutUser();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("responseFr","button clicked");
                SessionManager session;
                session = new SessionManager(getApplicationContext());
                session.createLoginSession(userid);

                ed1 = findViewById(R.id.user_ed);
                ed2 = findViewById(R.id.pwd_ed);

                userid = ed1.getText().toString();
                password = ed2.getText().toString();

                postRequest();

            }
        });
    }

    private void postRequest() {
        Log.d("responseFr","button clicked");
        RequestQueue requestQueue = Volley.newRequestQueue(Login.this);
        //String URL = "http://192.168.0.11:8080/login";
        //String URL = "http://192.168.0.7:8080/login";
        String URL = "http://192.168.43.120:8080/login";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject obj = new JSONObject(response);
                    ldapVerify = obj.getString("ldapVerify");
                    desg = obj.getString("designation");
                    Log.d("response",""+ldapVerify);
                    Log.d("responseFr",ldapVerify+"  "+desg);

                    if(true){
                        Log.d("responseFr",userid+" "+desg);
                        SharedPreferences pref=getApplicationContext().getSharedPreferences("MyPref",0);
                        SharedPreferences.Editor editor=pref.edit();

                        editor.putString("userDesg",desg);
                        //editor.putString("powerlogin","YES");
                        editor.commit();

                        if("ADMIN".equalsIgnoreCase(desg) || "SUPERVISOR".equalsIgnoreCase((desg)) || "FLOOREXECUTIVE".equalsIgnoreCase(desg)){
                            Intent intent = new Intent(Login.this,SupervisorLogin.class);
                            startActivity(intent);
                        }else {

                            Intent intent = new Intent(Login.this,Areas.class);
                            startActivity(intent);
                        }
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }



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
                params.put("loginid",""+userid);
                params.put("password",""+password);

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
}