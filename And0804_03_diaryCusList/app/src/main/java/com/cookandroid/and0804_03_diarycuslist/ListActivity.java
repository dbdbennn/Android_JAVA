package com.cookandroid.and0804_03_diarycuslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {
    ListView list; MyDBHelper myHelper;
    Cursor cursor; SQLiteDatabase sqlDB; DiaryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setTitle("일기 목록");
        list = findViewById(R.id.listView);
        myHelper = new MyDBHelper(this);
        sqlDB = myHelper.getReadableDatabase();
        cursor = sqlDB.rawQuery("SELECT * FROM DiaryTBL order by diaryDate desc;",null);
        if(cursor.getCount()>0){
            adapter = new DiaryAdapter(ListActivity.this, cursor, true);
            list.setAdapter(adapter);
        }
        else{
            adapter = null;
            list.setAdapter(adapter);
            Toast.makeText(getApplicationContext(), "일기 없음", Toast.LENGTH_SHORT).show();
        }
        sqlDB.close();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView txtName = view.findViewById(R.id.txtName);
                Intent in = new Intent(getApplicationContext(), DiaryActivity.class);
                in.putExtra("fname", txtName.getText().toString());
                startActivity(in);
            }
        });
    }
}