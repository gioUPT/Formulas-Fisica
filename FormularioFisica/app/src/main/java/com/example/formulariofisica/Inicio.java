package com.example.formulariofisica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inicio extends AppCompatActivity {

    Button btnEmpezar,
            btnMusica;

    MediaPlayer m1;

    int contador = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        btnEmpezar = (Button) findViewById(R.id.btnEmpezar);
        btnMusica = (Button) findViewById(R.id.btnMusica);

        m1 = MediaPlayer.create(this, R.raw.music);


        btnEmpezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act = new Intent(Inicio.this,Menu.class);
                startActivity(act);
            }
        });

        btnMusica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (contador%2 == 0){
                    m1.start();
                }else{
                    m1.pause();
                }
                contador++;
            }
        });
    }
}