package com.e.prismasegitiga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText edtNama;
    Button btnNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtNama = findViewById(R.id.nama);
        btnNext = findViewById(R.id.btn_next);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Bundle data  = new Bundle();
                data.putString("nama","Roby");
                data.putInt("umur",19);*/

                Intent next = new Intent(LoginActivity.this, MenuActivity.class);
                next.putExtra("names", edtNama.getText().toString());

                //next.putExtras(data);
                startActivity(next);
            }
        });

    }
}
