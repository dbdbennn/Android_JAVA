package com.cookandroid.and0725_05_changeimg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    Button btn_change, btn_visibilitiy;
    int setResourse = 1; // dog = 2
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.img);
        btn_change = findViewById(R.id.btn_change);
        btn_visibilitiy = findViewById(R.id.btn_visiblity);


        btn_visibilitiy.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                if(img.getVisibility()==view.VISIBLE){
                    img.setVisibility(View.INVISIBLE);
                    btn_visibilitiy.setText("보이기");
                } else {
                    img.setVisibility(View.VISIBLE);
                    btn_visibilitiy.setText("숨기기");
                }
            }
        });

        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(setResourse == 1){
                    img.setImageResource(R.drawable.dog);
                    setResourse = 2;
                }else{
                    img.setImageResource(R.drawable.cat2);
                    setResourse = 1;
                }
            }
        });
    }
}