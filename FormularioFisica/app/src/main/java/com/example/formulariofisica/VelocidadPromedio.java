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

public class VelocidadPromedio extends AppCompatActivity {

    EditText etVelocidadP,
            etVelocidadI,
            etVelocidadF;

    Button btnCalcular,
            btnLimpiar;

    TextView tvResultado;

    float velocidadP = 0,
            velocidadI = 0,
            velocidadF = 0;

    String resultado;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_velocidad_promedio);

        etVelocidadP = (EditText) findViewById(R.id.etAceleracion);
        etVelocidadI = (EditText) findViewById(R.id.etVi);
        etVelocidadF = (EditText) findViewById(R.id.etTiempo);
        
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
        if ((velocidadP == 0 && velocidadI == 0) ||
                (velocidadP == 0 && velocidadF == 0) ||
                (velocidadF == 0 && velocidadI == 0)){
            print("Llena al menos dos campos para realizar un calculo");
        }else{
            tvResultado.setText(resultado);
        }
    }

    private void print(String mensaje) {
        Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();
    }

    private void getDatos() {

        velocidadP = validar(etVelocidadP.getText().toString());
        velocidadF = validar(etVelocidadF.getText().toString());
        velocidadI = validar(etVelocidadI.getText().toString());

        if (velocidadP == 0){
            velocidadP = (velocidadI + velocidadF) / 2;
            resultado = "Velocidad = "+velocidadP+" m/s";

        }else if (velocidadF == 0){
            velocidadF = (2 * velocidadP) - velocidadI;
            resultado = "" +
                    "V.Final = "+velocidadF+" s";

        }else if (velocidadI == 0){
            velocidadI = (2 * velocidadP) - velocidadF;
            resultado = "V.Inicial = "+velocidadI+" s";
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
        etVelocidadP.setText("");

        tvResultado.setText("");
    }
}