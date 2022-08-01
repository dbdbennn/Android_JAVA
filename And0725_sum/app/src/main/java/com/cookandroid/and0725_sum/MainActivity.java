package com.cookandroid.and0725_sum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ipt_num;
    TextView res_view;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ipt_num = findViewById(R.id.ipt_num);
        res_view = findViewById(R.id.res_view);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(ipt_num.getText().toString());
                int result = 0;
                for (int i = 1; i <= num; i++) {
                    result += i;
                }

                res_view.setText("1부터 "+num+"까지 합 : " + result);

            }
        });

    }
}