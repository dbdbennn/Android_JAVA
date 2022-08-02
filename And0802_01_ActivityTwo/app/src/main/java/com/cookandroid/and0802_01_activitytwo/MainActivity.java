package com.cookandroid.and0802_01_activitytwo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText edtNum1, edtNum2;
    RadioGroup rg;
    String cac = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("계산기 [유정은]");
        btn = findViewById(R.id.btn);
        edtNum1 = findViewById(R.id.edtNum1);
        edtNum2 = findViewById(R.id.edtNum2);
        rg = findViewById(R.id.rg);


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (rg.getCheckedRadioButtonId()) {
                    case R.id.sum:
                        cac = "sum";
                        break;
                    case R.id.sub:
                        cac = "sub";
                        break;
                    case R.id.times:
                        cac = "times";
                        break;
                    case R.id.devide:
                        cac = "devide";
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), SecondActivity.class);
                in.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                in.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));
                in.putExtra("cac", cac);
                startActivityForResult(in, 0); // requestCode는 세컨엑티버티 번호
                // 세컨엑티비티에 return 값이 있을 때 사용(세컨에서 putExtra()해서 되돌려 받는 경우)
            }
        });
    }

    // 메서드로 onActivityResult()함수 생성

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            int res = data.getIntExtra("res", 0);
            Toast.makeText(getApplicationContext(), "결과 : "+res,
                    Toast.LENGTH_SHORT).show();
        }
    }
}