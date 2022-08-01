package com.cookandroid.and0801_02_activityone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnOpen;
    RadioGroup rg;
    EditText edtConent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("[유정은]첫번째 화면");
        setContentView(R.layout.activity_main);
        btnOpen = findViewById(R.id.btnOpen);
        rg = findViewById(R.id.rg);
        edtConent = findViewById(R.id.edtContent);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = edtConent.getText().toString();
                if(rg.getCheckedRadioButtonId() == R.id.rbSecond){
                    Intent in = new Intent(getApplicationContext(), SecoundAcitivity.class);
                    in.putExtra("content2", str);
                    startActivity(in);
                }else{
                    Intent in = new Intent(getApplicationContext(), ThirdActivity.class);
                    in.putExtra("content3", str);
                    startActivity(in);
                }
            }
        });

    }
}