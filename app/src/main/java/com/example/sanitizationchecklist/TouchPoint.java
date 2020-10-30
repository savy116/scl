package com.example.sanitizationchecklist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class TouchPoint extends AppCompatActivity  implements View.OnClickListener{
    int len = 0;
    Button button,button2,button3,button4,button5,button6,button7;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_point);

        String tp = getIntent().getStringExtra("Area");
        SharedPreferences pref=getApplicationContext().getSharedPreferences("MyPref",0);
        SharedPreferences.Editor editor=pref.edit();


        editor.putString("Area",tp);
        editor.putInt("AreaId",getIntent().getIntExtra("Areaid",0));
        editor.commit();
        String[] touchPoints;



        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);



        switch (tp){
            case "F Level Domestic and International":
                touchPoints = getResources().getStringArray(R.array.fldi);
                len=touchPoints.length;
                showButton(touchPoints);
                break;
            case "E and D Level Domestic":
                touchPoints = getResources().getStringArray(R.array.edd);
                len=touchPoints.length;
                showButton(touchPoints);
                break;
            case "E and D Level International and IIDT":
                touchPoints = getResources().getStringArray(R.array.edi);
                len=touchPoints.length;
                showButton(touchPoints);
                break;

            case "Carpark and Forecourt":
                touchPoints = getResources().getStringArray(R.array.cfc);
                len=touchPoints.length;
                showButton(touchPoints);
                break;
            case "IDAT BMA and Boarding gates":
                touchPoints = getResources().getStringArray(R.array.ibb);
                len=touchPoints.length;
                showButton(touchPoints);
                break;
            case "Trolley and Queue Manager":
                touchPoints = getResources().getStringArray(R.array.trq);
                len=touchPoints.length;
                showButton(touchPoints);
                break;



        }
//        if( tp.equalsIgnoreCase("F Level Domestic and International")){
//            touchPoints = getResources().getStringArray(R.array.fldi);
//            len=touchPoints.length;
//            showButton(touchPoints);
//
//        }


        }



public void showButton(String[] touchPoints){
    switch (len){
        case 2:
            button.setVisibility(View.GONE);
            button2.setVisibility(View.GONE);
            button3.setVisibility(View.GONE);
            button4.setVisibility(View.GONE);
            button5.setVisibility(View.GONE);
            button6.setText(touchPoints[0]);
            button7.setText(touchPoints[1]);
            break;
        case 3:
            button.setVisibility(View.GONE);
            button2.setVisibility(View.GONE);
            button3.setVisibility(View.GONE);
            button4.setVisibility(View.GONE);
            button5.setText(touchPoints[0]);
            button6.setText(touchPoints[1]);
            button7.setText(touchPoints[2]);
            break;
        case 4:
            button.setVisibility(View.GONE);
            button2.setVisibility(View.GONE);
            button3.setVisibility(View.GONE);
            button4.setText(touchPoints[0]);
            button5.setText(touchPoints[1]);
            button6.setText(touchPoints[2]);
            button7.setText(touchPoints[3]);
            break;
        case 5:
            button.setVisibility(View.GONE);
            button2.setVisibility(View.GONE);
            button3.setText(touchPoints[0]);
            button4.setText(touchPoints[1]);
            button5.setText(touchPoints[2]);
            button6.setText(touchPoints[3]);
            button7.setText(touchPoints[4]);
            break;
        case 6:
            button.setVisibility(View.GONE);
            button2.setText(touchPoints[0]);
            button3.setText(touchPoints[1]);
            button4.setText(touchPoints[2]);
            button5.setText(touchPoints[3]);
            button6.setText(touchPoints[4]);
            button7.setText(touchPoints[5]);
            break;
        case 7:
            button.setText(touchPoints[0]);
            button2.setText(touchPoints[1]);
            button3.setText(touchPoints[2]);
            button4.setText(touchPoints[3]);
            button5.setText(touchPoints[4]);
            button6.setText(touchPoints[5]);
            button7.setText(touchPoints[6]);
    }

}

    @Override
    public void onClick(View view){
        SharedPreferences pref=getApplicationContext().getSharedPreferences("MyPref",0);
        String TouchCheck = (pref.getString("TouchClick","Power Login"));

        if("MONITOR".equalsIgnoreCase(TouchCheck)){
            switch(view.getId()){
                case R.id.button:
                    Intent intent = new Intent(TouchPoint.this,Monitor.class);
                    String touchpoint = button.getText().toString();
                    intent.putExtra("touchpoint",touchpoint);
                    startActivity(intent);
                    break;
                case R.id.button2:
                    Intent intent2 = new Intent(TouchPoint.this,Monitor.class);
                     touchpoint = button2.getText().toString();
                    intent2.putExtra("touchpoint",touchpoint);
                    startActivity(intent2);
                    break;
                case R.id.button3:
                    Intent intent3 = new Intent(TouchPoint.this,Monitor.class);
                     touchpoint = button3.getText().toString();
                    intent3.putExtra("touchpoint",touchpoint);
                    startActivity(intent3);
                    break;
                case R.id.button4:
                    Intent intent4 = new Intent(TouchPoint.this,Monitor.class);
                     touchpoint = button4.getText().toString();
                    intent4.putExtra("touchpoint",touchpoint);
                    startActivity(intent4);
                    break;
                case R.id.button5:
                    Intent intent5 = new Intent(TouchPoint.this,Monitor.class);
                     touchpoint = button5.getText().toString();
                    intent5.putExtra("touchpoint",touchpoint);
                    startActivity(intent5);
                    break;
                case R.id.button6:
                    Intent intent6 = new Intent(TouchPoint.this,Monitor.class);
                     touchpoint = button6.getText().toString();
                    intent6.putExtra("touchpoint",touchpoint);
                    startActivity(intent6);
                    break;
                case R.id.button7:
                    Intent intent7 = new Intent(TouchPoint.this,Monitor.class);
                     touchpoint = button7.getText().toString();
                    intent7.putExtra("touchpoint",touchpoint);
                    startActivity(intent7);
                    break;

            }
        }else{

        switch (view.getId()){
            case R.id.button:
                String touchpoint = button.getText().toString();
                Intent intent =new Intent(TouchPoint.this,ContactArea.class);
                intent.putExtra("touchpoint",touchpoint);
                startActivity(intent);
                break;


            case R.id.button2:
                 touchpoint = button2.getText().toString();
                Intent intent2 =new Intent(TouchPoint.this,ContactArea.class);
                intent2.putExtra("touchpoint",touchpoint);
                startActivity(intent2);
                break;

            case R.id.button3:
                 touchpoint = button3.getText().toString();
                Intent intent3 =new Intent(TouchPoint.this,ContactArea.class);
                intent3.putExtra("touchpoint",touchpoint);
                startActivity(intent3);
                break;

            case R.id.button4:
                 touchpoint = button4.getText().toString();
                Intent intent4 =new Intent(TouchPoint.this,ContactArea.class);
                intent4.putExtra("touchpoint",touchpoint);
                startActivity(intent4);
                break;

            case R.id.button5:
                 touchpoint = button5.getText().toString();
                Intent intent5 =new Intent(TouchPoint.this,ContactArea.class);
                intent5.putExtra("touchpoint",touchpoint);
                startActivity(intent5);
                break;

            case R.id.button6:
                 touchpoint = button6.getText().toString();
                Intent intent6 =new Intent(TouchPoint.this,ContactArea.class);
                intent6.putExtra("touchpoint",touchpoint);
                startActivity(intent6);
                break;

            case R.id.button7:
                 touchpoint = button7.getText().toString();
                Intent intent7 =new Intent(TouchPoint.this,ContactArea.class);
                intent7.putExtra("touchpoint",touchpoint);
                startActivity(intent7);
                break;

        }}

    }}