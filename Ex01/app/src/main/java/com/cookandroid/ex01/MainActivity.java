package com.cookandroid.ex01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn; CheckBox chkEnabled, chkVisible, chkSpin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chkEnabled = findViewById(R.id.chkEnabled);
        chkVisible = findViewById(R.id.chkVisible);
        chkSpin = findViewById(R.id.chkSpin);
        btn = findViewById(R.id.btn);
        chkVisible.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) btn.setVisibility(View.VISIBLE);
                else btn.setVisibility(View.INVISIBLE);
            }
        });

        chkEnabled.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) btn.setEnabled(true);
                else btn.setEnabled(false);

            }
        });

        chkSpin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) btn.setRotation(45);
                else btn.setRotation(0);
            }
        });
    }
}