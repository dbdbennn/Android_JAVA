package com.cookandroid.and0804_03_diarycuslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btngoWrite, btngoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btngoList = findViewById(R.id.btnMainList);
        btngoWrite = findViewById(R.id.btnMainWrite);


        btngoList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(in);
            }
        });

        btngoWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), DiaryActivity.class);
                startActivity(in);
            }
        });

    }
}