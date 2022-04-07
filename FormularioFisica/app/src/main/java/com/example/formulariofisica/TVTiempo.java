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

public class TVTiempo extends AppCompatActivity {

    EditText etVelocidad,
            etTiempo;

    Button btnCalcular,
            btnLimpiar;

    TextView tvResultado;

    float aceleracion = (float) -9.81,
            velocidad = 0,
            tiempo = 0;

    String resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvtiempo);

        etTiempo = (EditText) findViewById(R.id.ettiempoS);
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
        if (aceleracion == 0 && tiempo == 0){
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
        tiempo = validar(etTiempo.getText().toString());


        if (velocidad == 0){
            velocidad = -1 * tiempo * aceleracion;
            resultado = "V.Inicial = "+velocidad+" m/s";

        }else if (tiempo == 0){
            tiempo = -1 * velocidad * aceleracion;

            resultado = "Tiempo = "+ tiempo +" s";

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
        etTiempo.setText("");

        tvResultado.setText("");
    }
}