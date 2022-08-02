package com.cookandroid.and0801_03_activityput;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtAge;
    Button btnIn;

    CheckBox[] chk = new CheckBox[3];
    Integer[] chkString = {R.id.chkDevelop, R.id.chkMusic, R.id.chkHealth};
    String name; int age, index = 0;
    ArrayList<String> hobby = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[유정은]정보 입력창");
        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        btnIn = findViewById(R.id.btnIn);

        for (int i = 0; i < chkString.length; i++) {
            final int index = i;
            chk[i] = findViewById(chkString[i]);
            chk[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(b)hobby.add(chk[index].getText().toString());
                    else hobby.remove(chk[index].getText().toString());
                }
            });
        }

        btnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = edtName.getText().toString();
                age = Integer.parseInt(edtAge.getText().toString());
                Intent in = new Intent(getApplicationContext(), ResultActivity.class);
                in.putExtra("name",name);
                in.putExtra("age", age);
                in.putExtra("hobby", hobby);
                startActivity(in);
            }
        });


    }

}