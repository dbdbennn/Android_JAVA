package com.cookandroid.and0726_06_survey;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox start;
    TextView tvQ;
    ImageView img;
    RadioGroup rg;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배달 음식 선호도 조사");
        start = findViewById(R.id.start);
        tvQ = findViewById(R.id.tvQ);
        img = findViewById(R.id.img);
        rg = findViewById(R.id.rg);
        reset = findViewById(R.id.reset);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.korean:img.setImageResource(R.drawable.donut); break;
                    case R.id.chinese:img.setImageResource(R.drawable.eclair); break;
                    case R.id.boon:img.setImageResource(R.drawable.froyo); break;
                    case R.id.night:img.setImageResource(R.drawable.gingerbread); break;
                }
            }
        });

        start.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    tvQ.setVisibility(View.VISIBLE);
                    img.setVisibility(View.VISIBLE);
                    rg.setVisibility(View.VISIBLE);
                    reset.setVisibility(View.VISIBLE);
                }else{
                    tvQ.setVisibility(View.INVISIBLE);
                    img.setVisibility(View.INVISIBLE);
                    rg.setVisibility(View.INVISIBLE);
                    reset.setVisibility(View.INVISIBLE);
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rg.clearCheck();
                img.setImageDrawable(null);
            }
        });

    }
}