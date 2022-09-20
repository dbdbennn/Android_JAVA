package com.cookandroid.and0830_loginsql;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private EditText edt1, edt2;
    private Button btn1, btn2;
    SQLiteDatabase sqIDB;
    MyDBHelper myDBHelper;

    private BottomAppBar bottomAppBar;
    private int bottomAppBarState = 0;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomAppBar = findViewById(R.id.bottom_app_bar);
        setSupportActionBar(bottomAppBar);
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomAppBarState = bottomAppBar.getFabAlignmentMode();
                if(bottomAppBarState==0){
                    bottomAppBar.setFabAlignmentMode(bottomAppBar.FAB_ALIGNMENT_MODE_END);
                }
                else{
                    bottomAppBar.setFabAlignmentMode(bottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
                }
            }
        });

        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.app_bar_menu1:
                        Toast.makeText(getApplicationContext(), "메뉴1", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.app_bar_menu2:
                        Toast.makeText(getApplicationContext(), "메뉴2", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            }
        });
        fab = findViewById(R.id.fab_btn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(in);
            }
        });

        edt1 = findViewById(R.id.edt_ID);
        edt2 = findViewById(R.id.edt_PASSWORD);
        btn1 = findViewById(R.id.btn_LOGIN);
        btn2 = findViewById(R.id.btn_Register);
        myDBHelper = new MyDBHelper(this);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(in);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = edt1.getText().toString().trim();
                String userPass = edt2.getText().toString().trim();
                sqIDB = myDBHelper.getReadableDatabase();
                Cursor cursor;
                cursor = sqIDB.rawQuery("SELECT userID, userPass FROM user where UserID='"+userID+"'"+"and userPass='"+userPass+"';",null);
                if (cursor.moveToFirst()){
                    Intent in = new Intent(MainActivity.this,LoginOkActivity.class);
                    in.putExtra("userID",userID);
                    in.putExtra("userPass",userPass);
                    startActivity(in);
                }
                else{//비밀번호나 id가 틀림, 로그인 실패(회원가입 안 되거나)
                    Toast.makeText(getApplicationContext(),"로그인 실패(id,pw 확인)", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.bottom_menu, menu);
        return true;
    }
}