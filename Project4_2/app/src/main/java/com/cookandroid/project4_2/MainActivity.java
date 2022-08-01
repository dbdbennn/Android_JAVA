package com.cookandroid.project4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtPet;    CheckBox chk;
    RadioGroup rg;  Button btnOk;   ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("유정은");
        chk = findViewById(R.id.chk);
        txtPet = findViewById(R.id.txtPet);
        rg = findViewById(R.id.rg);
        btnOk = findViewById(R.id.btnOk);
        img = findViewById(R.id.img);
        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(chk.isChecked()){ // true
                    txtPet.setVisibility(View.VISIBLE);
                    rg.setVisibility(View.VISIBLE);
                    btnOk.setVisibility(View.VISIBLE);
                    img.setVisibility(View.VISIBLE);
                } else {
                    txtPet.setVisibility(View.INVISIBLE);
                    rg.setVisibility(View.INVISIBLE);
                    btnOk.setVisibility(View.INVISIBLE);
                    img.setVisibility(View.INVISIBLE);
                    rg.clearCheck();
                    img.setImageDrawable(null);
                }
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                switch(rg.getCheckedRadioButtonId()){
                    case R.id.rdocat:
                        img.setImageResource(R.drawable.cat);
                        break;
                    case R.id.rdohorse:
                        img.setImageResource(R.drawable.horse);
                        break;
                    case R.id.rdofox:
                        img.setImageResource(R.drawable.fox);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),"동물 선택부터 해주세요.",
                                Toast.LENGTH_SHORT).show();
                }
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.rdocat :
                        img.setImageResource(R.drawable.cat);
                        break;
                    case R.id.rdohorse :
                        img.setImageResource(R.drawable.horse);
                        break;
                    case R.id.rdofox :
                        img.setImageResource(R.drawable.fox);
                        break;

                }
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}