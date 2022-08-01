package com.cookandroid.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtName;
    Button btnOK;
    EditText edx, edY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName = findViewById(R.id.txtName);
        btnOK = findViewById(R.id.btn);
        edY = findViewById(R.id.edY);
        edx = findViewById(R.id.edX);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(txtName.getText().equals("미림"))
                    txtName.setText("과학고");
                else txtName.setText("미림");
                String strX = edx.getText().toString();
                String strY = edY.getText().toString();
                int result = Integer.parseInt(strX)+Integer.parseInt(strY);

                Toast.makeText(getApplicationContext(), "변경:"+txtName.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}