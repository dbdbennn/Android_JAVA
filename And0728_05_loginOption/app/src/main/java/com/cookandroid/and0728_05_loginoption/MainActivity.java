package com.cookandroid.and0728_05_loginoption;

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
    Button btnLogin, btnCancel;
    EditText edtID, edtPW;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Login Service [유정은]");
        btnLogin = findViewById(R.id.btnLogin);
        btnCancel = findViewById(R.id.btnCancel);
        edtID = findViewById(R.id.edtID);
        edtPW = findViewById(R.id.edtPW);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dig = new AlertDialog.Builder(MainActivity.this);
                dig.setTitle("가입정보 확인");
                dig.setIcon(R.mipmap.ic_launcher);
                String message = "";
                message = "ID : "+edtID.getText().toString() +"\r\n" +
                        "PassWord : "+edtPW.getText().toString();
                dig.setMessage(message);

                dig.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "확인하셨습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                dig.show();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu p = new PopupMenu(getApplicationContext(), view);
                getMenuInflater().inflate(R.menu.popup, p.getMenu());
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.popup_reset:
                                edtID.setText("");
                                edtPW.setText("");break;

                            case R.id.popup_fin:
                                finish(); break;

                        }
                        return true;
                    }
                });
                p.show();
            }
        });
    }
}