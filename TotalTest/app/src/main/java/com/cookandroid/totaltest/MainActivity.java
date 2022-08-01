package com.cookandroid.totaltest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Switch swStart;
    EditText edtName, edtMid, edtFin, edtPerf, edtAttend;
    RadioGroup rgGrade;
    RadioButton rb1, rb2, rb3;
    Button btnCal, btnReset;
    TableLayout table;
    LinearLayout linear;
    TextView txtResult;
    int grade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("유정은[학점계산]");
        // findViewById() 넣기
        swStart = findViewById(R.id.swStart);
        edtAttend = findViewById(R.id.edtAttend);
        edtMid = findViewById(R.id.edtMid);
        edtFin = findViewById(R.id.edtFin);
        edtPerf = findViewById(R.id.edtPerf);
        edtName = findViewById(R.id.edtName);
        rgGrade = findViewById(R.id.rgGrade);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        btnCal = findViewById(R.id.btnCal);
        btnReset = findViewById(R.id.btnReset);
        table = findViewById(R.id.table);
        linear = findViewById(R.id.linear);
        txtResult = findViewById(R.id.txtResult);
        table.setVisibility(View.INVISIBLE);
        linear.setVisibility(View.INVISIBLE);

        swStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    table.setVisibility(View.VISIBLE);
                    linear.setVisibility(View.VISIBLE);
                }else{
                    table.setVisibility(View.INVISIBLE);
                    linear.setVisibility(View.INVISIBLE);
                }
            }
        });
        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int mid = Integer.parseInt(edtMid.getText().toString());
                int fin = Integer.parseInt(edtFin.getText().toString());
                int perf = Integer.parseInt(edtPerf.getText().toString());
                int attend = Integer.parseInt(edtAttend.getText().toString());
                String name = edtName.getText().toString();
                // 학년
                double total = mid*0.3+fin*0.3+perf*0.2+attend*0.2;
                String s = "";
                if(total>=90)s="A학점";
                else if(total>=80)s="B학점";
                else if(total>=70)s="C학점";
                else if(total>=60)s="D학점";
                else if(total>=0)s="F학점";
                else s="성적이 잘못됨(0~100점 사이가 아님)";
                String out = grade+"학년 "+name+"님 총점 : "+total+"\n학점 : "+s;
                Toast.makeText(getApplicationContext(),out,Toast.LENGTH_SHORT).show();
                txtResult.setText(out);
            }
        });
        rgGrade.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(radioGroup.getCheckedRadioButtonId()){
                    case R.id.rb1: grade=1; break;
                    case R.id.rb2: grade=2; break;
                    case R.id.rb3: grade=3; break;
                }
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grade=0;
                rgGrade.clearCheck();
                edtName.setText("");
                edtPerf.setText("0");
                edtAttend.setText("0");
                edtFin.setText("0");
                edtMid.setText("0");
                txtResult.setText("");
            }
        });
    }
}











