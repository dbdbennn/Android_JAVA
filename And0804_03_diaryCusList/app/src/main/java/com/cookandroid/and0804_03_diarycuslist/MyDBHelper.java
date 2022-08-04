package com.cookandroid.and0804_03_diarycuslist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {
    public MyDBHelper(@Nullable Context context){
        super(context, "DiaryDB.db", null, 1);
        //데이터베이스 이름 groupDB
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //테이블 생성
        String str = "CREATE TABLE DiaryTBL(_id integer primary key autoincrement, diaryDate char(10), content varchar(500))";
        sqLiteDatabase.execSQL(str); //이 코드로 실행하기?
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists DiaryTBL"); //drop은 테이블 삭제 명령어? groupTBL이 있으면 삭제해 주세요
        onCreate(sqLiteDatabase); //테이블 생성
    }
}