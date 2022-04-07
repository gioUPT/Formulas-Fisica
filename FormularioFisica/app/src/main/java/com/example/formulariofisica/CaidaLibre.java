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

public class CaidaLibre extends AppCompatActivity {

    EditText etVelocidadI,
            etVelocidadF,
            etTiempo;

    Button btnCalcular,
            btnLimpiar;

    TextView tvResultado;

    float aceleracion = (float) 9.81,
            velocidadInicial = 0,
            velocidadFinal = 0,
            tiempo = 0;

    String resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caida_libre);

        etVelocidadI = (EditText) findViewById(R.id.etvelocidadi);
        etVelocidadF = (EditText) findViewById(R.id.etvelocidadf);
        etTiempo = (EditText) findViewById(R.id.ettiempo);

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
        if ((velocidadInicial == 0 && velocidadFinal == 0) ||
                (tiempo == 0 && velocidadFinal == 0) ||
                (velocidadInicial == 0 && tiempo == 0)){
            print("Llena al menos dos campos para realizar un calculo");
        }else{
            tvResultado.setText(resultado);
        }
    }

    private void print(String mensaje) {
        Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();
    }

    private void getDatos() {

        tiempo = validar(etTiempo.getText().toString());
        velocidadInicial = validar(etVelocidadI.getText().toString());
        velocidadFinal = validar(etVelocidadF.getText().toString());


        if (tiempo == 0){
            tiempo = (velocidadFinal-velocidadInicial)/aceleracion;
            resultado = "Tiempo = "+tiempo+" s";

        }else if (velocidadInicial == 0){
            velocidadInicial = velocidadFinal - (aceleracion * tiempo);
            resultado = "Velocidad = "+velocidadInicial+" m/s";
        }
        else if (velocidadFinal == 0){
            velocidadFinal = (aceleracion * tiempo) + velocidadInicial;
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
        etTiempo.setText("");

        tvResultado.setText("");
    }
}