package com.cookandroid.and0801_02_activityone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    Button btnReturn;
    TextView txtContent3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("[유정은]세번째 화면");
        setContentView(R.layout.activity_third);
        btnReturn = findViewById(R.id.btnReturn);
        txtContent3= findViewById(R.id.txtContent3);
        /////////////////
        Intent in = getIntent();
        String str = in.getStringExtra("content3");
        /////////////////
        txtContent3.setText("넘겨받은 내용 : "+str);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(in);
            }
        });

    }
}