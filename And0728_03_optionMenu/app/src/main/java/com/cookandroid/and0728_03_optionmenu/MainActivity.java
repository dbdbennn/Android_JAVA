package com.cookandroid.and0728_03_optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    ImageView img;
    Button btnTel;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("옵션 메뉴 [유정은]");
        img = findViewById(R.id.main_img);
        btnTel = findViewById(R.id.btn);
        txt = findViewById(R.id.txt);
        btnTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("전화번호 등록");
                dlg.setIcon(R.mipmap.ic_launcher_round);
                final View dlgView = (View)View.inflate(MainActivity.this, R.layout.dlg, null); //dlg.xml을 java로 가져온 거임.
                dlg.setView(dlgView);

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText edName = dlgView.findViewById(R.id.edtName);
                        EditText edTel = dlgView.findViewById(R.id.edtTel);
                        String str = "이름: " + edName.getText().toString() + "\n" + "전화번호: " + edTel.getText().toString();
                        txt.setText(str);
                    }
                });
                dlg.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater minflater = getMenuInflater(); //메뉴 생성하는 것.
        minflater.inflate(R.menu.menu_change_img, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.img_hat:
                img.setImageResource(R.drawable.pic2);
                return true;

            case R.id.img_sit:
                img.setImageResource(R.drawable.pic4);
                return true;

            case R.id.img_twogirl:
                img.setImageResource(R.drawable.pic6);
                return true;

            default: Toast.makeText(getApplicationContext(), "선택 안됨", Toast.LENGTH_SHORT).show();
                return false;
        }
    }
}