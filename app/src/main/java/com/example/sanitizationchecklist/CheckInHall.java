package com.example.sanitizationchecklist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class CheckInHall extends AppCompatActivity  implements View.OnClickListener {
    Button button0,button1,button2,button3,button4,button5,button6,
            button7,button8,button9,button10,button11,button12,button13,
            button14,button15,button16,button17,button18,button19,button20,
            button21,button22,button23,button24,button25,button26,button27,
            button28,button29,button30,button31,button32,button33,button34,button35;
    String [] contactPoints;
    String touchPoint = "CHECK IN HALL";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in_hall);

        String tp = getIntent().getStringExtra("Area");
        SharedPreferences pref=getApplicationContext().getSharedPreferences("MyPref",0);
        SharedPreferences.Editor editor=pref.edit();


        editor.putString("Area",tp);
        editor.putInt("AreaId",getIntent().getIntExtra("Areaid",0));
        editor.commit();

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

        contactPoints = getResources().getStringArray(R.array.tp1);
        String [] uni;
        uni = getResources().getStringArray(R.array.UNIQUECONTACTAREAS);
        for (int i = 0;i<contactPoints.length;i++){
            for(int j = 0;j<uni.length;j++){
                if(contactPoints[i].equalsIgnoreCase(uni[j])){
                    Log.d("Checkinhallids",""+(j+1));
                    break;
                }
            }
        }
        Log.d("contact points",""+contactPoints.length);
        enableButtons();

    }

    public void enableButtons(){
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
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button0:
                String contactArea = button0.getText().toString();
                Intent intent0 =new Intent(CheckInHall.this,Submit.class);
                intent0.putExtra("contactArea",contactArea);intent0.putExtra("touchPoint",touchPoint);
                startActivity(intent0);
                break;

            case R.id.button1:
                contactArea = button1.getText().toString();
                Intent intent1 =new Intent(CheckInHall.this,Submit.class);
                intent1.putExtra("contactArea",contactArea);intent1.putExtra("touchPoint",touchPoint);
                startActivity(intent1);
                break;

            case R.id.button2:
                contactArea = button2.getText().toString();
                Intent intent2 =new Intent(CheckInHall.this,Submit.class);
                intent2.putExtra("contactArea",contactArea);intent2.putExtra("touchPoint",touchPoint);
                startActivity(intent2);
                break;

            case R.id.button3:
                contactArea = button3.getText().toString();
                Intent intent3 =new Intent(CheckInHall.this,Submit.class);
                intent3.putExtra("contactArea",contactArea);intent3.putExtra("touchPoint",touchPoint);
                startActivity(intent3);
                break;

            case R.id.button4:
                contactArea = button4.getText().toString();
                Intent intent4 =new Intent(CheckInHall.this,Submit.class);
                intent4.putExtra("contactArea",contactArea);intent4.putExtra("touchPoint",touchPoint);
                startActivity(intent4);
                break;

            case R.id.button5:
                contactArea = button5.getText().toString();
                Intent intent5 =new Intent(CheckInHall.this,Submit.class);
                intent5.putExtra("contactArea",contactArea);intent5.putExtra("touchPoint",touchPoint);
                startActivity(intent5);
                break;

            case R.id.button6:
                contactArea = button6.getText().toString();
                Intent intent6 =new Intent(CheckInHall.this,Submit.class);
                intent6.putExtra("contactArea",contactArea);intent6.putExtra("touchPoint",touchPoint);
                startActivity(intent6);
                break;

            case R.id.button7:
                contactArea = button7.getText().toString();
                Intent intent7 =new Intent(CheckInHall.this,Submit.class);
                intent7.putExtra("contactArea",contactArea);intent7.putExtra("touchPoint",touchPoint);
                startActivity(intent7);
                break;

            case R.id.button8:
                contactArea = button8.getText().toString();
                Intent intent8 =new Intent(CheckInHall.this,Submit.class);
                intent8.putExtra("contactArea",contactArea);intent8.putExtra("touchPoint",touchPoint);
                startActivity(intent8);
                break;

            case R.id.button9:
                contactArea = button9.getText().toString();
                Intent intent9 =new Intent(CheckInHall.this,Submit.class);
                intent9.putExtra("contactArea",contactArea);intent9.putExtra("touchPoint",touchPoint);
                startActivity(intent9);
                break;

            case R.id.button10:
                contactArea = button10.getText().toString();
                Intent intent10 =new Intent(CheckInHall.this,Submit.class);
                intent10.putExtra("contactArea",contactArea);intent10.putExtra("touchPoint",touchPoint);
                startActivity(intent10);
                break;

            case R.id.button11:
                contactArea = button11.getText().toString();
                Intent intent11 =new Intent(CheckInHall.this,Submit.class);
                intent11.putExtra("contactArea",contactArea);intent11.putExtra("touchPoint",touchPoint);
                startActivity(intent11);
                break;

            case R.id.button12:
                contactArea = button12.getText().toString();
                Intent intent12 =new Intent(CheckInHall.this,Submit.class);
                intent12.putExtra("contactArea",contactArea);intent12.putExtra("touchPoint",touchPoint);
                startActivity(intent12);
                break;

            case R.id.button13:
                contactArea = button13.getText().toString();
                Intent intent13 =new Intent(CheckInHall.this,Submit.class);
                intent13.putExtra("contactArea",contactArea);intent13.putExtra("touchPoint",touchPoint);
                startActivity(intent13);
                break;

            case R.id.button14:
                contactArea = button14.getText().toString();
                Intent intent14 =new Intent(CheckInHall.this,Submit.class);
                intent14.putExtra("contactArea",contactArea);intent14.putExtra("touchPoint",touchPoint);
                startActivity(intent14);
                break;

            case R.id.button15:
                contactArea = button15.getText().toString();
                Intent intent15 =new Intent(CheckInHall.this,Submit.class);
                intent15.putExtra("contactArea",contactArea);intent15.putExtra("touchPoint",touchPoint);
                startActivity(intent15);
                break;

            case R.id.button16:
                contactArea = button16.getText().toString();
                Intent intent16 =new Intent(CheckInHall.this,Submit.class);
                intent16.putExtra("contactArea",contactArea);intent16.putExtra("touchPoint",touchPoint);
                startActivity(intent16);
                break;

            case R.id.button17:
                contactArea = button17.getText().toString();
                Intent intent17 =new Intent(CheckInHall.this,Submit.class);
                intent17.putExtra("contactArea",contactArea);intent17.putExtra("touchPoint",touchPoint);
                startActivity(intent17);
                break;

            case R.id.button18:
                contactArea = button18.getText().toString();
                Intent intent18 =new Intent(CheckInHall.this,Submit.class);
                intent18.putExtra("contactArea",contactArea);intent18.putExtra("touchPoint",touchPoint);
                startActivity(intent18);
                break;

            case R.id.button19:
                contactArea = button19.getText().toString();
                Intent intent19 =new Intent(CheckInHall.this,Submit.class);
                intent19.putExtra("contactArea",contactArea);intent19.putExtra("touchPoint",touchPoint);
                startActivity(intent19);
                break;

            case R.id.button20:
                contactArea = button20.getText().toString();
                Intent intent20 =new Intent(CheckInHall.this,Submit.class);
                intent20.putExtra("contactArea",contactArea);intent20.putExtra("touchPoint",touchPoint);
                startActivity(intent20);
                break;

            case R.id.button21:
                contactArea = button21.getText().toString();
                Intent intent21 =new Intent(CheckInHall.this,Submit.class);
                intent21.putExtra("contactArea",contactArea);intent21.putExtra("touchPoint",touchPoint);
                startActivity(intent21);
                break;

            case R.id.button22:
                contactArea = button22.getText().toString();
                Intent intent22 =new Intent(CheckInHall.this,Submit.class);
                intent22.putExtra("contactArea",contactArea);intent22.putExtra("touchPoint",touchPoint);
                startActivity(intent22);
                break;

            case R.id.button23:
                contactArea = button23.getText().toString();
                Intent intent23 =new Intent(CheckInHall.this,Submit.class);
                intent23.putExtra("contactArea",contactArea);intent23.putExtra("touchPoint",touchPoint);
                startActivity(intent23);
                break;

            case R.id.button24:
                contactArea = button24.getText().toString();
                Intent intent24 =new Intent(CheckInHall.this,Submit.class);
                intent24.putExtra("contactArea",contactArea);intent24.putExtra("touchPoint",touchPoint);
                startActivity(intent24);
                break;

            case R.id.button25:
                contactArea = button25.getText().toString();
                Intent intent25 =new Intent(CheckInHall.this,Submit.class);
                intent25.putExtra("contactArea",contactArea);intent25.putExtra("touchPoint",touchPoint);
                startActivity(intent25);
                break;

            case R.id.button26:
                contactArea = button26.getText().toString();
                Intent intent26 =new Intent(CheckInHall.this,Submit.class);
                intent26.putExtra("contactArea",contactArea);intent26.putExtra("touchPoint",touchPoint);
                startActivity(intent26);
                break;

            case R.id.button27:
                contactArea = button27.getText().toString();
                Intent intent27 =new Intent(CheckInHall.this,Submit.class);
                intent27.putExtra("contactArea",contactArea);intent27.putExtra("touchPoint",touchPoint);
                startActivity(intent27);
                break;

            case R.id.button28:
                contactArea = button28.getText().toString();
                Intent intent28 =new Intent(CheckInHall.this,Submit.class);
                intent28.putExtra("contactArea",contactArea);intent28.putExtra("touchPoint",touchPoint);
                startActivity(intent28);
                break;

            case R.id.button29:
                contactArea = button29.getText().toString();
                Intent intent29 =new Intent(CheckInHall.this,Submit.class);
                intent29.putExtra("contactArea",contactArea);intent29.putExtra("touchPoint",touchPoint);
                startActivity(intent29);
                break;

            case R.id.button30:
                contactArea = button30.getText().toString();
                Intent intent30 =new Intent(CheckInHall.this,Submit.class);
                intent30.putExtra("contactArea",contactArea);intent30.putExtra("touchPoint",touchPoint);
                startActivity(intent30);
                break;

            case R.id.button31:
                contactArea = button31.getText().toString();
                Intent intent31 =new Intent(CheckInHall.this,Submit.class);
                intent31.putExtra("contactArea",contactArea);intent31.putExtra("touchPoint",touchPoint);
                startActivity(intent31);
                break;

            case R.id.button32:
                contactArea = button32.getText().toString();
                Intent intent32 =new Intent(CheckInHall.this,Submit.class);
                intent32.putExtra("contactArea",contactArea);intent32.putExtra("touchPoint",touchPoint);
                startActivity(intent32);
                break;

            case R.id.button33:
                contactArea = button33.getText().toString();
                Intent intent33 =new Intent(CheckInHall.this,Submit.class);
                intent33.putExtra("contactArea",contactArea);intent33.putExtra("touchPoint",touchPoint);
                startActivity(intent33);
                break;

            case R.id.button34:
                contactArea = button34.getText().toString();
                Intent intent34 =new Intent(CheckInHall.this,Submit.class);
                intent34.putExtra("contactArea",contactArea);intent34.putExtra("touchPoint",touchPoint);
                startActivity(intent34);
                break;

            case R.id.button35:
                contactArea = button35.getText().toString();
                Intent intent35 =new Intent(CheckInHall.this,Submit.class);
                intent35.putExtra("contactArea",contactArea);intent35.putExtra("touchPoint",touchPoint);
                startActivity(intent35);
                break;

    }
}}
