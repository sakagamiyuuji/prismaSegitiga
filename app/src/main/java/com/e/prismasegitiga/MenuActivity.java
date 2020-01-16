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
        weLL= findViewById(R.id.well);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //btnKotak=findViewById(R.id.btn_kotak);

        if(getIntent().getExtras() != null){
            //without bundle
            Intent data = getIntent();
            String nama = data.getStringExtra(LoginActivity.EXTRA_PERSON_NAME);
            weLL.setText("WELCOME " + nama);
            weLL.setVisibility(View.VISIBLE);
        }

/*      CARA HANS(BUNDLE)

        Bundle data = getIntent().getExtras();
        String s = data.getString("names");
        weLL.setText("Welcome "+ s );*/

        btnPrisma.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahKePrisma = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(pindahKePrisma);
            }
        }));

    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}