package com.cookandroid.and0728_02_menudlgtest;

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
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_Sex, btn_Login;
    EditText edt_Sex, edt_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("다이얼로그 메뉴 실습[유정은]");
        btn_Sex = findViewById(R.id.btn_Sex);
        btn_Login = findViewById(R.id.btn_Login);
        edt_Sex = findViewById(R.id.edt_Sex);
        edt_number = findViewById(R.id.edt_number);

        btn_Sex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu p = new PopupMenu(getApplicationContext(), view);
                getMenuInflater().inflate(R.menu.menu_popup, p.getMenu());
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.popup_man:
                                edt_Sex.setText("남자");
                                return true;
                            case R.id.popup_woman:
                                edt_Sex.setText("여자");
                                return true;
                            default:
                                Toast.makeText(getApplicationContext(), "선택안됨", Toast.LENGTH_SHORT).show();
                                return false;
                        }
                    }
                });
                p.show();
            }
        });

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("가입정보 확인");
                dlg.setIcon(R.mipmap.ic_launcher_round);
                dlg.setMessage("전화번호: " + edt_number.getText().toString() +"\n" + "성별: " + edt_Sex.getText().toString());
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "가입완료~", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "가입취소하였습니다", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
            }
        });
    }
    ////////////옵션메뉴, 팝업메뉴,다이얼로그///////////////

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater minflater = getMenuInflater();
        minflater.inflate(R.menu.menu_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option_return:
                Toast.makeText(getApplicationContext(), "초기화 합니다", Toast.LENGTH_SHORT).show();
                edt_Sex.setText("");
                edt_number.setText("");
                return true;
            case R.id.option_end:
                Toast.makeText(getApplicationContext(), "종료 합니다", Toast.LENGTH_SHORT).show();
                finish();
                return true;
            default:
                Toast.makeText(getApplicationContext(), "선택안됨", Toast.LENGTH_SHORT).show();
                return false;

        }
    }

}