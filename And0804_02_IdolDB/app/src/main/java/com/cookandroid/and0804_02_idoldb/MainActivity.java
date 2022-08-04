package com.cookandroid.and0804_02_idoldb;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtNumber;
    Button btnInsert, btnSelect, btnClear;
    ListView listView;

    MyDBHelper myHelper;
    SQLiteDatabase sqlDB;
    IdolAdapter iAdapter;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("IDOL MANAGER [유정은]");
        edtName = findViewById(R.id.edtName);
        edtNumber = findViewById(R.id.edtNum);
        btnInsert = findViewById(R.id.btnInsert);
        btnSelect = findViewById(R.id.btnSelect);
        btnClear = findViewById(R.id.btnClear);
        listView = findViewById(R.id.listView);

        myHelper = new MyDBHelper(this);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    sqlDB = myHelper.getWritableDatabase();
                    String name = edtName.getText().toString().trim();
                    String num = edtNumber.getText().toString().trim();
                    if(!name.isEmpty() || !num.isEmpty()){
                        String sql = "INSERT INTO contactTBL(name, num) VALUES ('"+name+"','"+num+"');";
                        sqlDB.execSQL(sql);
                        sqlDB.close();
                        Toast.makeText(getApplicationContext(), "입력 되었습니다.", Toast.LENGTH_SHORT).show();
                        edtName.setText(""); edtNumber.setText("");
                        btnSelect.callOnClick();
                    }else{
                        Toast.makeText(getApplicationContext(), "이름 또는 인원 수를 입력하세요.", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "입력 실패", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor = sqlDB.rawQuery("SELECT * FROM contactTBL;", null);
                if(cursor.getCount()>0) {
                    iAdapter = new IdolAdapter(MainActivity.this, cursor, true);

                    listView.setAdapter(iAdapter);
                }
                else { //초기화 되어 테이블이 없는 경우 adapter 초기화시킴
                    iAdapter=null;
                    listView.setAdapter(iAdapter);
                }
                sqlDB.close();
                Toast.makeText(getApplicationContext(),"조회 되었습니다.",Toast.LENGTH_SHORT).show();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //DB의 테이블 삭제 후 다시 생성
                sqlDB = myHelper.getWritableDatabase(); //수정 모드 오픈
                myHelper.onUpgrade(sqlDB, 1, 2); //숫자는 버전 의미로 아무거나
                sqlDB.close(); //close 꼭 해 주기!
                Toast.makeText(getApplicationContext(), "초기화 되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });


    }
    @Override
    protected void onStop(){
        super.onStop();
        cursor.close();
    }
}