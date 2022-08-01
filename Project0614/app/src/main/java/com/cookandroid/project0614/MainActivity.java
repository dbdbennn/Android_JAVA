package com.cookandroid.project0614;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    Button confirm, cancel, button;
    RadioButton rb2, rb3;
    String grade;
    CheckBox checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("유 정 은");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg = findViewById(R.id.rg);
        confirm = findViewById(R.id.confirm);
        cancel = findViewById(R.id.cancel);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        button = findViewById(R.id.button);
        checkbox = findViewById(R.id.checkbox);
        checkbox.setChecked(true);
        grade = null;

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==0) grade = "2학년";
                else grade="3학년";
                ///////////////////////////////////////////////////////
                if(radioGroup.getCheckedRadioButtonId()==R.id.rb2)
                    grade = rb2.getText().toString();
                else grade = rb3.getText().toString();
            }
        });

        ////////////////////////////////////////////////////////

        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grade = "2학년";
            }
        });
        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grade = "3학년";
            }
        });
        
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), grade+"입니다.", Toast.LENGTH_SHORT).show();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "취소했습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)button.setEnabled(true);
                else button.setEnabled(false);
            }
        });

    }
}