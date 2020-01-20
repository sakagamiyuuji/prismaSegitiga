package com.e.prismasegitiga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtNama;
    private Button btnNext;

    public static final String EXTRA_PERSON_NAME =  "extra_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialComponents();

        btnNext.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                nextActivity();
                break;
        }
    }

    private void nextActivity() {
        Intent next = new Intent(LoginActivity.this, MenuActivity.class);
        String personName = edtNama.getText().toString();
        next.putExtra(EXTRA_PERSON_NAME, personName);
        startActivity(next);
    }


    //CARA HANS
            /*@Override
            public void onClick(this) {
                *//*Bundle data  = new Bundle();
                data.putString("nama","Roby");
                data.putInt("umur",19);*//*

                Intent next = new Intent(LoginActivity.this, MenuActivity.class);
                next.putExtra("names", edtNama.getText().toString());

                //next.putExtras(data);
                startActivity(next);
            }*/
        //});

    //}

    public void initialComponents(){
        edtNama = findViewById(R.id.nama);
        btnNext = findViewById(R.id.btn_next);
    }
}
