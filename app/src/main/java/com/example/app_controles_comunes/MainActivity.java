package com.example.app_controles_comunes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText txtCorreo, txtFecha;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCorreo = (EditText)findViewById(R.id.txtCorreo);
        txtFecha = (EditText) findViewById(R.id.txtFecha);

    }

    public void btnFecha(View view){

        Calendar cal = Calendar.getInstance();
        int año = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH);
        int dia = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog= new DatePickerDialog(
                MainActivity.this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                dateSetListener,
                año,mes,dia);
        //A parece el cuadro de dialogo
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                month=month+1;
                txtFecha.setText(+dayOfMonth+"/"+month+"/"+year);
            }
        };

    }

    public void btnEnviar(View view){
        if (!validarCorreo()){
            txtCorreo.setError("El correo electrónico es inválido.");
        }
    }

    private boolean validarCorreo(){
        //Sacar la referencia
        String correo = txtCorreo.getText().toString();
        //comprueba si cumple con los caracteres de correo
        String patronCorreo = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(patronCorreo);
        Matcher matcher = pattern.matcher(correo);
        //Retorna false o true depende si esta correcto
        return matcher.matches();
    }
}