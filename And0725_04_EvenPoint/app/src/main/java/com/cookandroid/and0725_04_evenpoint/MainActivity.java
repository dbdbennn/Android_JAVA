package com.cookandroid.and0725_04_evenpoint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edt_1, edt_2;
    Button even, pointer;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_1 = findViewById(R.id.edt_1);
        edt_2 = findViewById(R.id.edt_2);
        even = findViewById(R.id.even);
        pointer = findViewById(R.id.pointer);
        tv = findViewById(R.id.tv);

        even.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(edt_1.getText().toString());
                int n2 = Integer.parseInt(edt_2.getText().toString());
                int result_even = 0;
                for (int i = n1; i < n2; i++) {
                    if (i % 2 == 0) {
                        result_even += i;
                    }
                }
                tv.setText("짝수의 합 : "+result_even);
            }
        });

        pointer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(edt_1.getText().toString());
                int n2 = Integer.parseInt(edt_2.getText().toString());

                if (n2 >= n1){
                    int result_pointer;

//                  result_pointer = n2;
//                    while(result_pointer >= n1){
//                        result_pointer = result_pointer - n1;
//                    }
//                    result_pointer = n2 - result_pointer;

                    result_pointer = n2 - n2 % n1;

                    tv.setText("가용 포인터 : " + result_pointer);
                }
                else if (n2 < n1){
                    tv.setText("가용 포인터가 부족합니다.");
                }
            }

        });

    }
}