package com.cookandroid.and0725_key;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.et);


        et.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int j, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_UP){
                    Toast.makeText(getApplicationContext(), et.getText().toString(),
                            Toast.LENGTH_SHORT).show();
                }

                else if (keyEvent.getKeyCode() == keyEvent.KEYCODE_ENTER){
                    int num = Integer.parseInt(et.getText().toString());
                    int result = 0;
                    for (int i = 1; i <= num; i++) {
                        result += i;
                    }

                    Toast.makeText(getApplicationContext(), "1부터 "+num+"까지 합 : " +
                            result, Toast.LENGTH_SHORT).show();

                }
                return false;
            }
        });
    }
}