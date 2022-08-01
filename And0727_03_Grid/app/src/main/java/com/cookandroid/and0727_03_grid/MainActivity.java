package com.cookandroid.and0727_03_grid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    RadioGroup rg;
    ImageView img;
    int select;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("유정은의 파스타 전문점");
        img = findViewById(R.id.img);
        rg = findViewById(R.id.rg);
        btn = findViewById(R.id.btn);


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.seafood: img.setImageResource(R.drawable.seafood); select = 0; break;
                    case R.id.tomato: img.setImageResource(R.drawable.tomato); select = 1; break;
                    case R.id.nara: img.setImageResource(R.drawable.nara); select = 2;break;
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (select){
                    case 0:
                        Toast.makeText(getApplicationContext(), "해물 파스타 (9,500원)을 주문하셨습니다.", Toast.LENGTH_SHORT).show(); break;
                    case 1:
                        Toast.makeText(getApplicationContext(), "토마토 파스타 (9,000원)을 주문하셨습니다.", Toast.LENGTH_SHORT).show(); break;
                    case 2:
                        Toast.makeText(getApplicationContext(), "까르보나라 (9,500원)을 주문하셨습니다.", Toast.LENGTH_SHORT).show(); break;
                }
            }
        });
    }
}