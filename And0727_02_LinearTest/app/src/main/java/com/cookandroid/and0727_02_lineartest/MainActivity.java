package com.cookandroid.and0727_02_lineartest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtX, edtY;
    Button btn;
    TextView txtResult;
    Spinner op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Linear Layout Test");
        edtX = findViewById(R.id.edtX);
        edtY = findViewById(R.id.edtY);
        btn = findViewById(R.id.btn);
        txtResult = findViewById(R.id.txtResult);
        op = findViewById(R.id.op);
        op.setSelection(0);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(edtX.getText().toString());
                int y = Integer.parseInt(edtY.getText().toString());
                int i = op.getSelectedItemPosition();
                switch (i){
                    case 0 : txtResult.setText(""+(x+y)); break;
                    case 1 : txtResult.setText(""+(x-y)); break;
                    case 2 : txtResult.setText(""+(x*y)); break;
                    case 3 : txtResult.setText(""+(x%y)); break;
                }
            }
        });
    }
}