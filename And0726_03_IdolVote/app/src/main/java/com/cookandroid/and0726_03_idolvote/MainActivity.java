package com.cookandroid.and0726_03_idolvote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    RadioGroup group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("VOTE IDOL");
        btn = findViewById(R.id.btn);
        group = findViewById(R.id.group);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (group.getCheckedRadioButtonId()){
                    case R.id.UniverseGirls:
                        Toast.makeText(getApplicationContext(),
                                "우주소녀 투표", Toast.LENGTH_SHORT).show(); break;
                    case R.id.BTS:
                        Toast.makeText(getApplicationContext(),
                                "방탄소년단(BTS) 투표", Toast.LENGTH_SHORT).show(); break;
                    case R.id.Seventeen:
                        Toast.makeText(getApplicationContext(),
                                "세븐틴 투표", Toast.LENGTH_SHORT).show(); break;

                }
            }
        });

    }
}