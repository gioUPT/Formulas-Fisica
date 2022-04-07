package com.example.formulariofisica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MRUA extends AppCompatActivity {

    Button btnAceleracion,
            btnVelocidadP,
            btnDistancia,
            btnVelocidadF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mrua);

        btnAceleracion = (Button) findViewById(R.id.btnMRU);
        btnVelocidadP = (Button) findViewById(R.id.btnMRA);
        btnDistancia = (Button) findViewById(R.id.btnCL);
        btnVelocidadF = (Button) findViewById(R.id.btnTV);

        btnAceleracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act = new Intent(MRUA.this, Aceleracion.class);
                startActivity(act);
            }
        });

        btnVelocidadP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act = new Intent(MRUA.this, VelocidadPromedio.class);
                startActivity(act);
            }
        });

        btnDistancia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act = new Intent(MRUA.this, Distancia.class);
                startActivity(act);
            }
        });

        btnVelocidadF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act = new Intent(MRUA.this, VelocidadFinal.class);
                startActivity(act);
            }
        });
    }
}