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

public class MRU extends AppCompatActivity {

    EditText etVelocidad,
                etDistancia,
                etTiempo;

    TextView tvResultado;

    Button btnCalcular,
            btnLimpiar;

    float distancia = 0,
            velocidad = 0,
            tiempo = 0;

    String resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mru);

        etVelocidad = (EditText) findViewById(R.id.etVelocidad);
        etDistancia = (EditText) findViewById(R.id.etDistancia);
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
                etVelocidad.setText("");
                etDistancia.setText("");
                etTiempo.setText("");
                tvResultado.setText("");

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
        if ((distancia == 0 && velocidad == 0) ||
                (distancia == 0 && tiempo == 0) ||
                (tiempo == 0 && velocidad == 0)){
            print("Llena al menos dos campos para realizar un calculo");
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
        velocidad = validar(etVelocidad.getText().toString());

        if (distancia == 0){
            distancia = velocidad * tiempo;
            resultado = "Distancia = "+distancia+" m";

        }else if (tiempo == 0){
            tiempo = distancia / velocidad;
            resultado = "Tiempo = "+tiempo+" s";

        }else if (velocidad == 0){
            velocidad = distancia / tiempo;
            resultado = "Velocidad = "+velocidad+" m/s";
        }
    }

    private float validar(String texto) {
        float valor = 0;
        if (!texto.equals("")){
            valor = Float.parseFloat(texto);
        }
        return valor;
    }
}