package com.example.proyectoguiado1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Impresion extends AppCompatActivity {
    private TextView IDDinero;
    private TextView IDTasa;
    private TextView IDCDIA;
    private TextView IDTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impresion);
        IDDinero = findViewById(R.id.Dinero);
        IDTasa = findViewById(R.id.Tasa);
        IDCDIA = findViewById(R.id.CDIA);
        IDTotal = findViewById(R.id.Total);


        Intent intent = getIntent();
        String cantidadDinero = intent.getStringExtra("cantidadDinero");
        String tasaInteres = intent.getStringExtra("tasaInteres");
        int dias = intent.getIntExtra("dias", 0);
        String resultado = intent.getStringExtra("resultado");


        IDDinero.setText("La cantidad de dinero ingresada fue: " + cantidadDinero);
        IDTasa.setText("La tasa de interés ingresada fue: " + tasaInteres);
        IDCDIA.setText("La cantidad de días fueron: " + dias);
        IDTotal.setText("El resultado es: " + resultado);
    }

}