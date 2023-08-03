package com.example.proyectoguiado1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private SeekBar Barra_dias;
//Declaración de variables

    private EditText Cantidad_Dinero;

    private EditText Tasa_Interes;

    private TextView dias;

    private Button calcular;

    private Button limpiar;

    private Button imprimir;

    private TextView resultado;











    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.Cantidad_Dinero = findViewById(R.id.txtCantidadDeDinero);
        Barra_dias = findViewById(R.id.sbDias);
        this.Tasa_Interes = findViewById(R.id.txtTasaDeInteres);
        this.resultado = findViewById(R.id.txtRespuesta);
        this.calcular =findViewById(R.id.btnCalcular);
        this.limpiar =findViewById(R.id.btnLimpiar);
        this.dias = findViewById(R.id.txtDia);
        this.imprimir =findViewById(R.id.btnImpresion);
        calcular.setOnClickListener(this::calcular);
        limpiar.setOnClickListener(this::limpiar);
        this.imprimir.setOnClickListener(this::siguiente);
        Barra_dias.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                dias.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void siguiente(View view) {
        Intent intent = new Intent(this, Impresion.class);
        intent.putExtra("cantidadDinero", Cantidad_Dinero.getText().toString());
        intent.putExtra("tasaInteres", Tasa_Interes.getText().toString());
        intent.putExtra("dias", Barra_dias.getProgress());
        intent.putExtra("resultado", resultado.getText().toString());
        startActivity(intent);
    }


    public void calcular(View view){
        String cantidadStr = this.Cantidad_Dinero.getText().toString();
        String tasaStr = this.Tasa_Interes.getText().toString();
        int dias = Barra_dias.getProgress();

        if (cantidadStr.isEmpty() || tasaStr.isEmpty()) {
            Toast.makeText(this, "No puede dejar valores vacíos", Toast.LENGTH_SHORT).show();
            return;
        }

        double Cantidad = Double.parseDouble(cantidadStr);
        double Tasa = Double.parseDouble(tasaStr) / 100;


        double Resultado = Cantidad * Math.pow(1 + Tasa / 365, dias);

        Toast.makeText(this, "EXITOSO " + Resultado, Toast.LENGTH_SHORT).show();
        resultado.setText("El resultado es: " + Resultado);
    }

    private void limpiar(View view) {
        if (this.Cantidad_Dinero != null) {
            this.Cantidad_Dinero.setText("");
        }

        if (this.Tasa_Interes != null) {
            this.Tasa_Interes.setText("");
        }

        if (this.resultado != null) {
            this.resultado.setText("El resultado es: 0");
        }

        if (Barra_dias != null) {
            Barra_dias.setProgress(0);
            dias.setText("0");
        }

        Toast.makeText(this, "Se ha limpiado todo el contenido", Toast.LENGTH_SHORT).show();
    }




}