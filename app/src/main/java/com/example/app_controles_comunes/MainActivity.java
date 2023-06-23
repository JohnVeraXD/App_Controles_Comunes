package com.example.app_controles_comunes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBiding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private boolean validarCorreo(){
        //Sacar la referencia
        EditText txtcorreo = (EditText)findViewById(R.id.txtCorreo);
        String correo = txtcorreo.getText().toString();
        return if(correo.isEmpty()){
            binding.correo
        }
    }
}