package com.cookandroid.and0728_04_optioncontext;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtName, txtTel;
    String name ="", tel="";
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Register PhoneNumbers [유정은] " );
        txtName = findViewById(R.id.txtName);
        txtTel = findViewById(R.id.txtTel);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu p = new PopupMenu(getApplicationContext(), view);
                getMenuInflater().inflate(R.menu.menu_option, p.getMenu());
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.context_reset:
                                name = "";
                                tel = "";
                                txtName.setText("");
                                txtTel.setText(""); break;

                            case R.id.context_fin:
                                finish();

                        }
                        return true;
                    }
                });
                p.show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater minflater = getMenuInflater();
        minflater.inflate(R.menu.menu_context, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemReg:
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("전화 번호 등록");
                final View dlgView = (View)View.inflate(MainActivity.this, R.layout.dlg, null); //dlg.xml을 java로 가져온 거임.
                dlg.setView(dlgView);

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText edName = dlgView.findViewById(R.id.edtName);
                        EditText edTel = dlgView.findViewById(R.id.edtTel);
                        name += edName.getText().toString()+'\n';
                        tel += edTel.getText().toString()+'\n';
                        txtName.setText(name);
                        txtTel.setText(tel);
                    }
                });
                dlg.setNegativeButton("취소",null);
                dlg.show(); break;
            case R.id.itemBlue: txtName.setTextColor(Color.BLUE); txtTel.setTextColor(Color.BLUE); break;
            case R.id.itemGreen: txtName.setTextColor(Color.GREEN); txtTel.setTextColor(Color.GREEN); break;
            case R.id.itemDefault: txtName.setTextColor(Color.GRAY); txtTel.setTextColor(Color.GRAY); break;
        }
        return true;
    }
}