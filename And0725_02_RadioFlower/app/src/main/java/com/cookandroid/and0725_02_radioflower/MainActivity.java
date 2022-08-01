package com.cookandroid.and0725_02_radioflower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Flower Select");
        rg = findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rbRose:
                        Toast.makeText(getApplicationContext(),
                                "장미 선택", Toast.LENGTH_SHORT).show(); break;
                    case R.id.rbPansy:
                        Toast.makeText(getApplicationContext(),
                                "팬지 선택", Toast.LENGTH_SHORT).show(); break;
                    case R.id.rbLily:
                        Toast.makeText(getApplicationContext(),
                                "백합 선택", Toast.LENGTH_SHORT).show(); break;
                }
            }
        });
    }
}