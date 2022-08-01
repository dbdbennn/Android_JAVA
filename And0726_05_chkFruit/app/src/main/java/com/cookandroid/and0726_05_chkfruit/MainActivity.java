package com.cookandroid.and0726_05_chkfruit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView tvres;
    CheckBox chkList [] = new CheckBox[4];
    Integer chkText [] = {R.id.strawberry, R.id.grape, R.id.kiwi, R.id.grapefruit};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Select Fruit [유정은]");
        btn = findViewById(R.id.btn);
        tvres = findViewById(R.id.tvres);


        for (int i = 0; i < chkList.length; i++) {
            chkList[i] = findViewById(chkText[i]);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result="";
                for (int i = 0; i < chkList.length; i++) {
                    if(chkList[i].isChecked() == true){
                        result += chkList[i].getText().toString()+" ";
                    }
                }
                if (result == ""){
                    tvres.setText("아무것도 선택되지 않았습니다.");
                } else{
                    tvres.setText("선택결과 : "+result);
                }
            }
        });
        /////////setOnCheckedChangeListener/////////////
        for (int i = 0; i < chkList.length; i++) {
            chkList[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    btn.performClick(); // btn의 Onclick 함수 호출
                }
            });
        }
    }
}