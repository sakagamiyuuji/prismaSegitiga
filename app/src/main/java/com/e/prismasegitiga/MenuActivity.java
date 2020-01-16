package com.e.prismasegitiga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    Button btnPrisma, btnKotak;
    TextView weLL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnPrisma=findViewById(R.id.btn_prisma);

        //btnKotak=findViewById(R.id.btn_kotak);

        weLL= findViewById(R.id.well);
        Bundle data = getIntent().getExtras();
        String s = data.getString("names");
        weLL.setText("Welcome "+ s);

        btnPrisma.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahKePrisma = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(pindahKePrisma);
            }
        }));

    }
}