package com.cookandroid.and0727_05_tablelayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BankOutput extends Fragment {
    Button btnOuputOk;
    EditText edtOutput;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.bank_output, container,false);
        btnOuputOk = v.findViewById(R.id.btnOuputOk);
        edtOutput = v.findViewById(R.id.edtOutput);
        btnOuputOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(edtOutput.getText().toString());
                BankData.data -= n;
                BankData.txtData.setText("잔액 : " + BankData.data + "원");
                Toast.makeText(getContext(), n+"원이 출금되어 "+ BankData.data +"원 남았습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
}
