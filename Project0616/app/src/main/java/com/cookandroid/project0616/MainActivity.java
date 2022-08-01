package com.cookandroid.project0616;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button[] btnNums = new Button[10];
    Integer[] ids = {R.id.n0, R.id.n1, R.id.n2, R.id.n3,
            R.id.n4,R.id.n5,R.id.n6,R.id.n7,R.id.n8,R.id.n9};

    Button sum, sub, times;
    TextView result;
    EditText t1, t2;
    int tn1 = 0, tn2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 =findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        sum = findViewById(R.id.sum);
        sub = findViewById(R.id.sub);
        times = findViewById(R.id.times);
        result = findViewById(R.id.result);



        for(int i = 0; i<btnNums.length; i++) {
            btnNums[i] = findViewById(ids[i]);

            final int index = i;
            btnNums[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(t1.isFocused()){
                        String s = t1.getText().toString()+index;
                        t1.setText(s);
                    }else if(t2.isFocused()){
                        String s = t2.getText().toString()+index;
                        t2.setText(s);
                    }else{
                        Toast.makeText(getApplicationContext(),
                                "에디터부터 선택하세요.",Toast.LENGTH_SHORT).show();
                    }
                }
            });


        }

        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tn1 = Integer.parseInt(t1.getText().toString());
                tn2 = Integer.parseInt(t2.getText().toString());
                result.setText("계산결과: "+(tn1+tn2));
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tn1 = Integer.parseInt(t1.getText().toString());
                tn2 = Integer.parseInt(t2.getText().toString());
                result.setText("계산결과: "+(tn1-tn2));
            }
        });
        times.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tn1 = Integer.parseInt(t1.getText().toString());
                tn2 = Integer.parseInt(t2.getText().toString());
                result.setText("계산결과: "+(tn1*tn2));
            }
        });





    }//onCreate()

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.option, menu); // xmL을 메뉴로 등록
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int x = Integer.parseInt(t1.getText().toString());
        int y = Integer.parseInt(t2.getText().toString());
        switch (item.getItemId()){
            case R.id.itemAdd:
               result.setText("계산결과: "+x+y); break;
            case R.id.itemMul:
                result.setText("계산결과: "+x*y); break;
            case R.id.itemExit:
                finish();

        }
        return true;
    }
}