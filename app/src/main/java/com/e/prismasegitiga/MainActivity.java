package com.e.prismasegitiga;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    TextView tvHasil;
    Button btnHitung, btnReset;
    private EditText p,l,t;
    private double result, panjang,lebar,tinggi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p = findViewById(R.id.p_alas);
        l = findViewById(R.id.lbr_alas);
        t = findViewById(R.id.t);
        btnHitung = findViewById(R.id.btn_hitung);
        btnReset = findViewById(R.id.btn_reset);
        tvHasil = findViewById(R.id.tv_hasil);


        //HITUNG
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String length = p.getText().toString().trim();
                String width = l.getText().toString().trim();
                String height = t.getText().toString().trim();

                boolean isEmptyInput = false;

                if(TextUtils.isEmpty(length)){
                    isEmptyInput=true;
                    p.setError("FIELD PANJANG TIDAK BOLEH KOSONG");
                    Toast.makeText(getApplicationContext(),"PANJANG TIDAK BOLEH KOSONG",Toast.LENGTH_SHORT).show();
                }

                if(TextUtils.isEmpty(width)){
                    isEmptyInput=true;
                    p.setError("FIELD LEBAR TIDAK BOLEH KOSONG");
                    Toast.makeText(getApplicationContext(),"LEBAR TIDAK BOLEH KOSONG",Toast.LENGTH_SHORT).show();
                }

                if(TextUtils.isEmpty(height)){
                    isEmptyInput=true;
                    p.setError("FIELD TINGGI TIDAK BOLEH KOSONG");
                    Toast.makeText(getApplicationContext(),"TINGGI TIDAK BOLEH KOSONG",Toast.LENGTH_SHORT).show();
                }

                try {

                    panjang = Double.parseDouble(length);
                    lebar = Double.parseDouble(width);
                    tinggi = Double.parseDouble(height);
                    result = (panjang*lebar/2)*tinggi;
                    tvHasil.setText(String.valueOf(result));
                }
                catch (Exception e){
                    panjang =0;
                    lebar =0;
                    tinggi =0;
                    //tvHasil.setText(R.string.lengkapi_data);
                }

            }

        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = 0;
                tvHasil.setText(String.valueOf(result));
                p.setText(String.valueOf(""));
                l.setText(String.valueOf(""));
                t.setText(String.valueOf(""));
            }
        });

    }
}
