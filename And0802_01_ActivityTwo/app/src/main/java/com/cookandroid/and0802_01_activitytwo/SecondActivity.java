package com.cookandroid.and0802_01_activitytwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    Button btnReturn;
    int res = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("두번째 창");
        btnReturn = findViewById(R.id.btnReturn);

        Intent in = getIntent();
        int x = in.getIntExtra("Num1", 0);
        int y = in.getIntExtra("Num2", 0);
        String cac = in.getStringExtra("cac");

        switch (cac){
            case "sum": res=x + y; break;
            case "sub":  res= x - y; break;
            case "times":  res= x * y; break;
            case "devide": res = x / y;
                break;
            default:
                res = 0;
        }

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent out = new Intent(getApplicationContext(), MainActivity.class);
                out.putExtra("res", res);
                setResult(RESULT_OK, out);
                finish();
            }
        });
    }
}