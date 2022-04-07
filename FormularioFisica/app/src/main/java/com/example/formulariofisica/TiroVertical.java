package com.example.formulariofisica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TiroVertical extends AppCompatActivity {

    Button btnAltura,
            btnTiempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiro_vertical);

        btnAltura = (Button) findViewById(R.id.btnMRU);
        btnTiempo = (Button) findViewById(R.id.btnMRA);

        btnAltura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act = new Intent(TiroVertical.this, TVAltura.class);
                startActivity(act);
            }
        });

        btnTiempo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act = new Intent(TiroVertical.this, TVTiempo.class);
                startActivity(act);
            }
        });
    }
}