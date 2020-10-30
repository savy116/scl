package com.example.sanitizationchecklist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SupervisorLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisor_login);

        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);

        TextView textView = findViewById(R.id.textView2);
        SharedPreferences pref=getApplicationContext().getSharedPreferences("MyPref",0);


        textView.setText(pref.getString("userDesg","Power Login"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref=getApplicationContext().getSharedPreferences("MyPref",0);
                SharedPreferences.Editor editor=pref.edit();
                editor.putString("TouchClick","MONITOR");
                editor.commit();
                Intent intent = new Intent(SupervisorLogin.this,SuperviseArea.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref=getApplicationContext().getSharedPreferences("MyPref",0);
                SharedPreferences.Editor editor=pref.edit();
                editor.putString("TouchClick","CHECKLIST");
                editor.commit();
                Intent intent = new Intent(SupervisorLogin.this,Areas.class);
                startActivity(intent);
            }
        });

    }

}