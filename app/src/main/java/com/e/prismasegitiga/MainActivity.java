package com.e.prismasegitiga;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView tvHasil;
    Button btnHitung;
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
        tvHasil = findViewById(R.id.tv_hasil);


        //HITUNG
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    panjang = Double.parseDouble(p.getText().toString());
                    lebar = Double.parseDouble(l.getText().toString());
                    tinggi = Double.parseDouble(t.getText().toString());
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

    }
}
