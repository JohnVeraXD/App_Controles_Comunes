package com.example.app_controles_comunes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivityDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_datos);

        TextView txtDatos=(TextView)findViewById(R.id.txtDatos);

        //Recuperamos la información pasada en el intent
        Bundle bundle = this.getIntent().getExtras();

        //Construimos el mensaje a mostrar

        txtDatos.setText("Hola!, Bienvenido \n " +
                "Cédula: " + bundle.getString("Cedula") + "\n" +
                "Nombre: " + bundle.getString("Nombre") + "\n" +
                "Fecha: " + bundle.getString("Fecha") + "\n" +
                "Ciudad: " + bundle.getString("Ciudad") + "\n" +
                "Correo: " + bundle.getString("Correo") + "\n" +
                "Telefono: " + bundle.getString("Telefono") + "\n" +
                "Género: " + bundle.getString("Genero") + "\n"

        );
    }
}