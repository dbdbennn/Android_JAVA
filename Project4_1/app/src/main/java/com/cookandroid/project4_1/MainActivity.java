package com.cookandroid.project4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//    TextView txtColor;
    EditText edX, edY;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        edX = findViewById(R.id.edX);
        edY = findViewById(R.id.edY);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        txtResult = findViewById(R.id.txtResult);
        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String strx = edX.getText().toString();
                String stry = edY.getText().toString();
                int result = Integer.parseInt(strx)+Integer.parseInt(stry);
                txtResult.setText("계산결과:"+result);
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String strx = edX.getText().toString();
                String stry = edY.getText().toString();
                int result = Integer.parseInt(strx)-Integer.parseInt(stry);
                txtResult.setText("계산결과:"+result);
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String strx = edX.getText().toString();
                String stry = edY.getText().toString();
                int result = Integer.parseInt(strx)*Integer.parseInt(stry);
                txtResult.setText("계산결과:"+result);
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String strx = edX.getText().toString();
                String stry = edY.getText().toString();
                if(Integer.parseInt(stry)!=0) {
                    int result = Integer.parseInt(strx) / Integer.parseInt(stry);
                    txtResult.setText("계산결과:" + result);
                }
                else txtResult.setText("계산결과: 0으로 나눌 수 없음");
            }
        });



//        txtColor = findViewById(R.id.txtColor);
//        txtColor.setTextColor(Color.RED);
//        txtColor.setText("Text_Change");
    }
}