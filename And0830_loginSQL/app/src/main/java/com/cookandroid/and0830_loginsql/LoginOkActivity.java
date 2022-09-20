package com.cookandroid.and0830_loginsql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginOkActivity extends AppCompatActivity {
    private TextView tv_id, tv_pass;
    private Button btn_exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ok);
        tv_id = findViewById(R.id.tv_id);
        tv_pass = findViewById(R.id.tv_pass);
        btn_exit = findViewById(R.id.btn_exit);
        Intent in = getIntent();
        String userID = in.getStringExtra("userID");
        String userPass = in.getStringExtra("userPass");
        tv_id.setText(userID);
        tv_pass.setText(userPass);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}