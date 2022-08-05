package com.cookandroid.and0804_03_diarycuslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class DiaryActivity extends AppCompatActivity {
    DatePicker dp; Button btnWrite, btnDel;
    EditText edtDiary; String fileName; MyDBHelper myDBHelper; SQLiteDatabase sqlDB;
    int cYear, cMonth, cDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
        dp = findViewById(R.id.WritedatePicker);
        btnWrite = findViewById(R.id.btnWrite);
        btnDel = findViewById(R.id.btnDel);
        edtDiary = findViewById(R.id.edtDiary);
        Intent in = getIntent();
        String fname = in.getStringExtra("fname"); // 2022_08_05 >> {"2022","08","05"}
        String arr[] = fname.split("_"); // "_"문자로 분리 >> 문자배열처리
        cYear = Integer.parseInt(arr[0]);
        cMonth = Integer.parseInt(arr[1])-1; // 자바에서 월은 0부터 시작
        cDay = Integer.parseInt(arr[2]);
        myDBHelper = new MyDBHelper(this);
        fileName = cYear + "_" + (cMonth + 1) + "_" + cDay;
        String str = readDiary(fileName);
        Toast.makeText(getApplicationContext(), fileName, Toast.LENGTH_SHORT).show();
        edtDiary.setText(str);

        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int y, int m, int d) {
                fileName = y + "_" + (m + 1) + "_" + d;
                String str = readDiary(fileName);//일기 있으면 읽어오기
                edtDiary.setText(str);
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    sqlDB = myDBHelper.getWritableDatabase();
                    sqlDB.execSQL("delete from DiaryTBL where diaryDate = '" + fileName + "' ;");
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(), "삭제됨", Toast.LENGTH_SHORT).show();
                    edtDiary.setText("");
                    btnWrite.setText("새로저장"); btnDel.setVisibility(View.GONE);
                } catch (Exception e){
                    Toast.makeText(getApplicationContext(), "삭제 실패", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnWrite.getText().toString().equals("새로저장")){ // insert 처리
                    sqlDB = myDBHelper.getWritableDatabase();
                    sqlDB.execSQL("insert into DiaryTBL(diaryDate, content)"+"values( '"+fileName+"', '"+
                            edtDiary.getText().toString() +"');");
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(), "입력됨", Toast.LENGTH_SHORT).show();
                    btnWrite.setText("수정하기"); btnDel.setVisibility(View.VISIBLE);
                }else { // Update 처리
                    sqlDB = myDBHelper.getWritableDatabase();
                    sqlDB.execSQL("update DiaryTBL set content = '"+edtDiary.getText().toString()
                            +"'where diaryDate = '"+fileName+"'; ");
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(), "수정됨", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public String readDiary(String fileName){
        String diaryStr = null;
        sqlDB = myDBHelper.getReadableDatabase();
        Cursor cursor;
        cursor = sqlDB.rawQuery("SELECT * FROM DiaryTBL WHERE diaryDate = '"+fileName+"';", null);

        if(cursor.moveToFirst() == true){
            diaryStr = cursor.getString(2);
            btnWrite.setText("수정하기");
            btnDel.setVisibility(View.VISIBLE);
        }else {
            btnWrite.setText("새로저장");
            btnDel.setVisibility(View.GONE);
        }
        cursor.close(); sqlDB.close();

        return diaryStr;
    }
}