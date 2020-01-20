package com.e.prismasegitiga;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnPrisma, btnCall, btnWeb;
    TextView weLL;
    private final String TEL = "tel: ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        initialComponent();

        btnPrisma.setOnClickListener(this);
        btnCall.setOnClickListener(this);
        btnWeb.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getIntent().getExtras() != null) {
            //without bundle
            Intent data = getIntent();
            String nama = data.getStringExtra(LoginActivity.EXTRA_PERSON_NAME);
            weLL.setText("WELCOME " + nama);
            weLL.setVisibility(View.VISIBLE);

            /*      CARA HANS(BUNDLE)

        Bundle data = getIntent().getExtras();
        String s = data.getString("names");
        weLL.setText("Welcome "+ s );*/
/*
            btnPrisma.setOnClickListener((new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent pindahKePrisma = new Intent(MenuActivity.this, MainActivity.class);
                    startActivity(pindahKePrisma);
                }
            }));*/
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_prisma:
                prismaActivity();
                break;

            case R.id.btn_call:
                String nomorHp="081388452854";
                Uri tel = Uri.parse(TEL +nomorHp);

                Intent dialContact = new Intent(Intent.ACTION_DIAL, tel);
                startActivity(dialContact);
                break;

            case R.id.btn_web:
                showDialog();
                break;

        }
    }


    private void prismaActivity(){
        Intent pindahKePrisma = new Intent(MenuActivity.this, MainActivity.class);
        startActivity(pindahKePrisma);
    }

    private void showDialog(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        //set Title Alert;
        alert.setTitle("Apakah anda ingin membuka halaman web kami?");

        //set pesan dari dialog
        alert.setMessage("Klik YA untuk Ya!")
                .setIcon(R.mipmap.ic_launcher)
                .setCancelable(true)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String web = "www.facebook.com";
                        Uri domain = Uri.parse("http://" +web);

                        Intent openWeb = new Intent(Intent.ACTION_VIEW, domain);
                        Intent pilihan = Intent.createChooser(openWeb, "Mau buka pake apa?");
                        if(openWeb.resolveActivity(getPackageManager()) != null){
                            startActivity(pilihan);
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Tidak ada Aplikasi Tersedia", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        //create alert dialog dari builder
        AlertDialog alertDialog = alert.create();
        alertDialog.show();

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public void initialComponent(){
        btnPrisma=findViewById(R.id.btn_prisma);
        weLL= findViewById(R.id.well);
        btnCall = findViewById(R.id.btn_call);
        btnWeb = findViewById(R.id.btn_web);
    }

    public void darkMode(Configuration configuration){
        int currentNightMode = configuration.uiMode & Configuration.UI_MODE_NIGHT_MASK;
        switch (currentNightMode) {
            case Configuration.UI_MODE_NIGHT_NO:
                // Night mode is not active, we're using the light theme
                break;
            case Configuration.UI_MODE_NIGHT_YES:
                // Night mode is active, we're using dark theme
                break;
        }
    }
}