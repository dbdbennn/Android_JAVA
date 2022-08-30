package com.cookandroid.and0830_loginsql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtId, edtPW;
    private Button btnLogin, btnSignUp;
    SQLiteDatabase sqlDB;
    MyDBHelper myHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Login [유정은]");
        edtId = findViewById(R.id.edtId);
        edtPW = findViewById(R.id.edtPW);
        btnLogin = findViewById(R.id.btnLogin);
        edtPW = findViewById(R.id.edtPW);
        btnSignUp = findViewById(R.id.btnSignUp);
        myHelper = new MyDBHelper(this);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(in);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = edtId.getText().toString().trim();
                String userPass = edtPW.getText().toString().trim();
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("select userID, userPass from user where userID='"+userID+"' "
                        +"and userPass='"+userPass+"';", null);
                if(cursor.moveToFirst()){
                    Intent in = new Intent(MainActivity.this, LoginActivity.class);
                    in.putExtra("userID", userID);
                    in.putExtra("userPass", userPass);
                    startActivity(in);
                }
                else{
                    Toast.makeText(getApplicationContext(), "로그인 실패(id, pw확인)", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}