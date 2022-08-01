package com.cookandroid.and0801_02_activityone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecoundAcitivity extends AppCompatActivity {
    Button btnReturn;
    TextView txtContent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("[유정은]두번째 화면");
        setContentView(R.layout.activity_secound);
        btnReturn = findViewById(R.id.btnReturn);
        txtContent2= findViewById(R.id.txtContent2);
        /////////////////
        Intent in = getIntent();
        String str = in.getStringExtra("content2");
        /////////////////
        txtContent2.setText("넘겨받은 내용 : "+str);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(in);
            }
        });

    }
}