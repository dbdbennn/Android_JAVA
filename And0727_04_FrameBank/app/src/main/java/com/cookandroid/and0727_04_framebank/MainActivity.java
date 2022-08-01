package com.cookandroid.and0727_04_framebank;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout FBal, FDepo, FWd;
    Button btnBal, btnDepo, btnWd, bD, bWd;
    EditText etWd, etDepo;
    TextView txtBal;
    int balance = 10000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("And Internet Banking");
        FBal = findViewById(R.id.FBal); btnBal = findViewById(R.id.btnBal);
        FDepo = findViewById(R.id.FDepo); btnDepo = findViewById(R.id.btnDepo);
        FWd = findViewById(R.id.FWd); btnWd = findViewById(R.id.btnWd);
        txtBal = findViewById(R.id.txtBal);

        bD = findViewById(R.id.bD); bWd = findViewById(R.id.bWd);
        etWd = findViewById(R.id.etWd); etDepo = findViewById(R.id.etDepo);

        btnBal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBal.setBackgroundColor(Color.parseColor("#F4F47F"));
                btnDepo.setBackgroundColor(Color.parseColor("#E1DDDD"));
                btnWd.setBackgroundColor(Color.parseColor("#E1DDDD"));
                FBal.setVisibility(View.VISIBLE);
                FDepo.setVisibility(View.INVISIBLE);
                FWd.setVisibility(View.INVISIBLE);
            }
        });
        btnDepo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBal.setBackgroundColor(Color.parseColor("#E1DDDD"));
                btnDepo.setBackgroundColor(Color.parseColor("#F4F47F"));
                btnWd.setBackgroundColor(Color.parseColor("#E1DDDD"));
                FBal.setVisibility(View.INVISIBLE);
                FDepo.setVisibility(View.VISIBLE);
                FWd.setVisibility(View.INVISIBLE);
            }
        });

        btnWd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBal.setBackgroundColor(Color.parseColor("#E1DDDD"));
                btnDepo.setBackgroundColor(Color.parseColor("#E1DDDD"));
                btnWd.setBackgroundColor(Color.parseColor("#F4F47F"));
                FBal.setVisibility(View.INVISIBLE);
                FDepo.setVisibility(View.INVISIBLE);
                FWd.setVisibility(View.VISIBLE);
            }
        });

        bD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int m = Integer.parseInt(etDepo.getText().toString());
                balance += m;
                txtBal.setText("잔액 : "+balance+"원");
            }
        });

        bWd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int m = Integer.parseInt(etWd.getText().toString());
                if(m <= balance) {
                    balance -= m;
                    txtBal.setText("잔액 : "+balance+"원");
                } else {
                    Toast.makeText(getApplicationContext(), "잔액 부족으로 출금할 수 없습니다.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}