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

public class TVAltura extends AppCompatActivity {

    EditText etVelocidad,
            etAltura;

    Button btnCalcular,
            btnLimpiar;

    TextView tvResultado;

    float aceleracion = (float) -9.81,
            velocidad = 0,
            altura = 0;

    String resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvaltura);

        etAltura = (EditText) findViewById(R.id.etaltura);
        etVelocidad = (EditText) findViewById(R.id.etvelocidadi);

        tvResultado = (TextView) findViewById(R.id.etResultado);

        btnCalcular = (Button) findViewById(R.id.btncalcular);
        btnLimpiar = (Button) findViewById(R.id.btnlimpiar);

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
        if (aceleracion == 0 && altura == 0){
            print("Llena almenos un campo para realizar un calculo");
        }else{
            tvResultado.setText(resultado);
        }
    }

    private void print(String mensaje) {
        Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();
    }

    private void getDatos() {

        velocidad = validar(etVelocidad.getText().toString());
        altura = validar(etAltura.getText().toString());


        if (velocidad == 0){
            velocidad = (float) Math.sqrt((-1 * altura * 2 * aceleracion));
            resultado = "V.Inicial = "+velocidad+" m/s";

        }else if (altura == 0){
            altura = (float) ((float) -1 * Math.pow(velocidad,2) / 2 * aceleracion);

            resultado = "Altura = "+ altura +" m";

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
        etVelocidad.setText("");
        etAltura.setText("");

        tvResultado.setText("");
    }
}