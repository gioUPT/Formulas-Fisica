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

public class VelocidadFinal extends AppCompatActivity {

    EditText etAceleracion,
            etVelocidadI,
            etVelocidadF,
            etDistancia;

    Button btnCalcular,
            btnLimpiar;

    TextView tvResultado;

    float aceleracion = 0,
            velocidadInicial = 0,
            velocidadFinal = 0,
            distancia = 0;

    String resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_velocidad_final);

        etAceleracion = (EditText) findViewById(R.id.etAceleracion);
        etVelocidadI = (EditText) findViewById(R.id.etVi);
        etVelocidadF = (EditText) findViewById(R.id.etVf);
        etDistancia = (EditText) findViewById(R.id.etTiempo);

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
        if ((aceleracion == 0 && velocidadInicial == 0 && velocidadFinal == 0) ||
                (distancia == 0 && velocidadInicial == 0 && velocidadFinal == 0) ||
                (aceleracion == 0 && velocidadInicial == 0 && distancia == 0) ||
                (aceleracion == 0 && distancia == 0 && velocidadFinal == 0)){
            print("Llena solamente dos campos para realizar un calculo");
        }else{
            tvResultado.setText(resultado);
        }
    }

    private void print(String mensaje) {
        Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();
    }

    private void getDatos() {

        aceleracion = validar(etAceleracion.getText().toString());
        distancia = validar(etDistancia.getText().toString());
        velocidadInicial = validar(etVelocidadI.getText().toString());
        velocidadFinal = validar(etVelocidadF.getText().toString());


        if (aceleracion == 0){
            aceleracion = (float) ((Math.pow(velocidadFinal,2) -
                                    Math.pow(velocidadInicial,2)) /
                                        2*distancia);
            resultado = "Aceleracion = "+aceleracion+" m/s²";

        }else if (distancia == 0){
            distancia = (float) ((Math.pow(velocidadFinal,2) -
                                    Math.pow(velocidadInicial,2)) /
                                    2 * aceleracion);

            resultado = "Distancia = "+ distancia +" m";

        }else if (velocidadInicial == 0){
            velocidadInicial = (float) Math.sqrt( (double)
                                                    (Math.pow(velocidadFinal,2) -
                                                            (2 * aceleracion*distancia))
                                                );

            resultado = "V.Inicial = "+velocidadInicial+" m/s";
        }
        else if (velocidadFinal == 0){
            velocidadFinal = (float) Math.sqrt( (double)
                                            (Math.pow(velocidadInicial,2) +
                                                    (2*aceleracion*distancia)));

            resultado = "V.final = "+velocidadFinal+" m/s";
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
        etAceleracion.setText("");
        etDistancia.setText("");
        tvResultado.setText("");
    }
}