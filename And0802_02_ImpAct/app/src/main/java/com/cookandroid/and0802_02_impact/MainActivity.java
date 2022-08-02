package com.cookandroid.and0802_02_impact;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnDial, btnWeb, btnGoogle, btnSearch, btnPhoto,
    btnContact, btnEmail, btnFinish, btnSms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDial = findViewById(R.id.btnDial);
        btnWeb = findViewById(R.id.btnWeb);
        btnGoogle = findViewById(R.id.btnGoogle);
        btnSearch = findViewById(R.id.btnSearch);
        btnPhoto = findViewById(R.id.btnPhoto);
        btnContact = findViewById(R.id.btnContact);
        btnEmail = findViewById(R.id.btnEmail);
        btnSms = findViewById(R.id.btnSms);
        btnFinish = findViewById(R.id.btnFinish);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:010-1234-5678");
                Intent in = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(in);
            }
        });

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://m.naver.com");
                Intent in = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(in);
            }
        });

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://maps.google.com/maps?q="
                +37.568256+","+126.897240);
                Intent in = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(in);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Intent.ACTION_WEB_SEARCH);
                in.putExtra(SearchManager.QUERY, "안드로이드");
                startActivity(in);
            }
        });

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Intent.ACTION_SENDTO);
                in.putExtra("sms_body", "안녕하세요?");
                in.setData(Uri.parse("smsto:"+Uri.encode("010-1234-5678")));
                startActivity(in);
            }
        });

        btnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(in);
            }
        });

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("content://contacts/people/");
                Intent in = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(in);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("mailto:"+"birchTree@naver.com");
                Intent in = new Intent(Intent.ACTION_SENDTO, uri);
                in.putExtra("sms_body","hello");
                startActivity(in);
            }
        });
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

