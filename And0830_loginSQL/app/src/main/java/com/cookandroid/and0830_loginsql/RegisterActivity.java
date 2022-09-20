package com.cookandroid.and0830_loginsql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private EditText edt_id, edt_pass, edt_name, edt_age;
    private Button btn_register;
    SQLiteDatabase sqlDB;
    MyDBHelper myHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edt_id = findViewById(R.id.edt_id);
        edt_pass = findViewById(R.id.edt_pass);
        edt_age = findViewById(R.id.edt_age);
        edt_name = findViewById(R.id.edt_name);
        btn_register = findViewById(R.id.btn_register);
        myHelper = new MyDBHelper(this);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = edt_id.getText().toString().trim();
                String userPass = edt_pass.getText().toString().trim();
                String userName = edt_name.getText().toString().trim();
                int userAge = Integer.parseInt(edt_age.getText().toString().trim());
                try {
                    if(!userID.isEmpty() && !userPass.isEmpty()) {
                        sqlDB = myHelper.getWritableDatabase();
                        sqlDB.execSQL("INSERT INTO user(userID, userPass, userName, userAge) VALUES " +
                                "( '"+ userID + "', "+ "'" + userPass + "', " + "'"+ userName + "', "+userAge + ");");
                        sqlDB.close();
                        Toast.makeText(getApplicationContext(), "회원 등록 성공", Toast.LENGTH_SHORT).show();
                        Intent in = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(in);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "id, password 필수입력", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "입력 실패(아이디 중복)", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}