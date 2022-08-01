package com.cookandroid.and0726_04_internet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText eturl;
    Button Showurl, urlOpen;
    RadioGroup rg;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_round);
        setTitle("URL OPEN [유정은]");
        eturl = findViewById(R.id.eturl);
        Showurl = findViewById(R.id.Showurl);
        urlOpen = findViewById(R.id.urlOpen);
        rg = findViewById(R.id.rg);
        img = findViewById(R.id.img);

        Showurl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        eturl.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        urlOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = eturl.getText().toString();
                Intent urlOpen = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(urlOpen);
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.chknougat: img.setImageResource(R.drawable.nougat); break;
                    case R.id.chkoreo: img.setImageResource(R.drawable.oreo); break;
                }
            }
        });
    }
}