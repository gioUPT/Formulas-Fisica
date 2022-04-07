package com.example.formulariofisica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    Button btnMRU,
            btnMRUA,
            btnCaida,
            btnTiro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnMRU = (Button) findViewById(R.id.btnMRU);
        btnMRUA = (Button) findViewById(R.id.btnMRA);
        btnCaida = (Button) findViewById(R.id.btnCL);
        btnTiro = (Button) findViewById(R.id.btnTV);

        btnMRU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act = new Intent(Menu.this, MRU.class);
                startActivity(act);
            }
        });

        btnMRUA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act = new Intent(Menu.this, MRUA.class);
                startActivity(act);
            }
        });

        btnCaida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act = new Intent(Menu.this, CaidaLibre.class);
                startActivity(act);
            }
        });

        btnTiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act = new Intent(Menu.this, TiroVertical.class);
                startActivity(act);
            }
        });

    }
}