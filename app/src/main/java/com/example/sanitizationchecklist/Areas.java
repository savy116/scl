package com.example.sanitizationchecklist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Areas extends AppCompatActivity implements View.OnClickListener {
    String area;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areas);



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
    @Override
public void onClick(View view){
    switch (view.getId()){
        case R.id.button:
            area = getString(R.string.a1);int areaid = 1;
            Intent intent = new Intent(Areas.this,CheckInHall.class);
            intent.putExtra("Areaid",areaid);
            startActivity(intent);
            break;


        case R.id.button2:
            area = getString(R.string.a2);areaid = 2;
            Intent intent2 = new Intent(Areas.this,TouchPoint.class);
            intent2.putExtra("Area",area);
            intent2.putExtra("Areaid",areaid);
            startActivity(intent2);

            break;
        case R.id.button3:
            area = getString(R.string.a3);areaid = 3;
            Intent intent3 = new Intent(Areas.this,TouchPoint.class);
            intent3.putExtra("Area",area);
            intent3.putExtra("Areaid",areaid);
            startActivity(intent3);

            break;
        case R.id.button4:
            area = getString(R.string.a4);areaid = 4;
            Intent intent4 = new Intent(Areas.this,TouchPoint.class);
            intent4.putExtra("Area",area);
            intent4.putExtra("Areaid",areaid);
            startActivity(intent4);

            break;
        case R.id.button5:
            area = getString(R.string.a5);areaid = 5;
            Intent intent5 = new Intent(Areas.this,TouchPoint.class);
            intent5.putExtra("Area",area);
            intent5.putExtra("Areaid",areaid);
            startActivity(intent5);

            break;
        case R.id.button6:
            area = getString(R.string.a6);areaid = 6;
            Intent intent6 = new Intent(Areas.this,TouchPoint.class);
            intent6.putExtra("Area",area);
            intent6.putExtra("Areaid",areaid);
            startActivity(intent6);

            break;
        case R.id.button7:
            area = getString(R.string.a7);areaid = 7;
            Intent intent7 = new Intent(Areas.this,TouchPoint.class);
            intent7.putExtra("Area",area);
            intent7.putExtra("Areaid",areaid);
            startActivity(intent7);

            break;

    }

}
}