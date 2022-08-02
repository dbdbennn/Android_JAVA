package com.cookandroid.and0801_03_activityput;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    TextView tvResult;
    Button btnReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tvResult = findViewById(R.id.tvResult);
        btnReturn = findViewById(R.id.btnReturn);
        setTitle("[유정은] 결과창");
        Intent in = getIntent();
        String name = in.getStringExtra("name");
        int age = in.getIntExtra("age",0);
        ArrayList<String> hobby = in.getStringArrayListExtra("hobby");

        String str = "이름 : "+name+"\n"+ "나이 : "+age+"\n"+ "취미 : ";
        for(String h : hobby)tvResult.setText(str += h+" ");
        tvResult.setText(str);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(in);
            }
        });
    }
}