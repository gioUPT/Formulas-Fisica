package com.example.formulariofisica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Distancia extends AppCompatActivity {

    EditText etDistancia,
            etVelocidadI,
            etVelocidadF,
            etTiempo;

    Button btnCalcular,
            btnLimpiar;

    TextView tvResultado;

    float distancia = 0,
            velocidadInicial = 0,
            velocidadFinal = 0,
            tiempo = 0;

    String resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distancia);

        etDistancia = (EditText) findViewById(R.id.etAceleracion);
        etVelocidadI = (EditText) findViewById(R.id.etVi);
        etVelocidadF = (EditText) findViewById(R.id.etVf);
        etTiempo = (EditText) findViewById(R.id.etTiempo);
        tvResultado = (TextView) findViewById(R.id.etResultado);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDatos();
                showDatos();
                noFocus();
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpiar();
            }
        });
    }
    private void noFocus() {
        // Check if no view has focus:
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void showDatos() {
        if ((distancia == 0 && velocidadInicial == 0 && velocidadFinal == 0) ||
                (tiempo == 0 && velocidadInicial == 0 && velocidadFinal == 0) ||
                (distancia == 0 && velocidadInicial == 0 && tiempo == 0) ||
                (distancia == 0 && tiempo == 0 && velocidadFinal == 0)){
            print("Llena solamente dos campos para realizar un calculo");
        }else{
            tvResultado.setText(resultado);
        }
    }

    private void print(String mensaje) {
        Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();
    }

    private void getDatos() {

        distancia = validar(etDistancia.getText().toString());
        tiempo = validar(etTiempo.getText().toString());
        velocidadInicial = validar(etVelocidadI.getText().toString());
        velocidadFinal = validar(etVelocidadF.getText().toString());


        if (distancia == 0){
            distancia = ((velocidadFinal+velocidadInicial) / 2) * tiempo;
            resultado = "Distancia = "+ distancia +" m";

        }else if (tiempo == 0){
            tiempo = distancia / ((velocidadFinal+velocidadInicial)/2);
            resultado = "Tiempo = "+tiempo+" s";

        }else if (velocidadInicial == 0){
            velocidadInicial = ((distancia / tiempo) * 2) - velocidadFinal;
            resultado = "Velocidad = "+velocidadInicial+" m/s";
        }
        else if (velocidadFinal == 0){
            velocidadFinal = ((distancia / tiempo) * 2) - velocidadInicial;
            resultado = "Velocidad = "+velocidadFinal+" m/s";
        }
    }

    private float validar(String texto) {
        float valor = 0;
        if (!texto.equals("")){
            valor = Float.parseFloat(texto);
        }
        return valor;
    }

    private void limpiar() {
        etVelocidadI.setText("");
        etVelocidadF.setText("");
        etDistancia.setText("");
        etTiempo.setText("");
        tvResultado.setText("");
    }
}