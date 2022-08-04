package com.cookandroid.and0804_01_dbcuradp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtTel;
    Button btnAdd, btnSelect;
    ListView listView;

    MyDBHelper myHelper;
    SQLiteDatabase sqlDB;
    ContactAdapter cAdapter;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("DB Cursor Adapter[유정은]");
        btnAdd = findViewById(R.id.btnInsert);
        btnSelect = findViewById(R.id.btnSelect);
        listView = findViewById(R.id.listView);
        edtName = findViewById(R.id.edtName);
        edtTel = findViewById(R.id.edtTel);
        myHelper = new MyDBHelper(this);
        btnSelect.callOnClick();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView txtName = view.findViewById(R.id.txtName);
                TextView txtTel = view.findViewById(R.id.txtTel);
                String out = "이름 : "+txtName.getText().toString();
                out += "\n연락처 : "+txtTel.getText().toString();
                Toast.makeText(getApplicationContext(), out, Toast.LENGTH_SHORT).show();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    sqlDB = myHelper.getWritableDatabase();
                    String name = edtName.getText().toString().trim();
                    String tel = edtTel.getText().toString().trim();
                    if(!name.isEmpty() || !tel.isEmpty()){
                        String sql = "INSERT INTO contactTBL(name, tel) VALUES ('"+name+"','"+tel+"');";
                        sqlDB.execSQL(sql);
                        sqlDB.close();
                        Toast.makeText(getApplicationContext(), "입력됨", Toast.LENGTH_SHORT).show();
                        edtName.setText(""); edtTel.setText("");
                        btnSelect.callOnClick();
                    }else{
                        Toast.makeText(getApplicationContext(), "이름 또는 전화번호를 입력하세요.", Toast.LENGTH_SHORT).show();
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
                if(cursor.getCount()>0){
                    cAdapter = new ContactAdapter(MainActivity.this, cursor,true);

                    listView.setAdapter(cAdapter);
                }else{
                    cAdapter=null;
                    listView.setAdapter(cAdapter);
                }
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "조회됨", Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    protected void onStop(){
        super.onStop();
        cursor.close();
    }
}