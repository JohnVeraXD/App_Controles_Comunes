package com.example.app_controles_comunes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText txtCorreo, txtFecha, txtCedula, txtNombre, txtCiudad, txtTelefono;
    RadioButton rbMasculino, rbFemenino;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCedula = (EditText) findViewById(R.id.txtCedula);
        txtNombre =(EditText) findViewById(R.id.txtNombre);
        txtFecha = (EditText) findViewById(R.id.txtFecha);
        txtCiudad = (EditText)findViewById(R.id.txtCiudad);
        txtCorreo = (EditText) findViewById(R.id.txtCorreo);
        txtTelefono = (EditText) findViewById(R.id.txtTeléfono);
        rbMasculino = (RadioButton) findViewById(R.id.rbMasculino);
        rbFemenino = (RadioButton) findViewById(R.id.rbFemenino);


    }

    //Ingresar la fecha mediante un calendario
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


    //Validar el correo
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

    private boolean ValidarVacios(){

        Boolean auxiliar = true;
        String cedula = txtCedula.getText().toString();
        String nombre = txtNombre.getText().toString();
        String fecha = txtFecha.getText().toString();
        String ciudad = txtCiudad.getText().toString();
        String telefono = txtTelefono.getText().toString();
        if (cedula.isEmpty()){
            txtCedula.setError("Este campo no puede esta vacio");
            return false;
        }
        if (nombre.isEmpty()){
            txtNombre.setError("Este campo no puede esta vacio");
            return false;
        }
        if (fecha.isEmpty()){
            txtFecha.setError("Este campo no puede esta vacio");
            return false;
        }
        if (ciudad.isEmpty()){
            txtCiudad.setError("Este campo no puede esta vacio");
            return false;
        }
        if (telefono.isEmpty()){
            txtTelefono.setError("Este campo no puede esta vacio");
            return false;
        }
        return auxiliar;
    }

    public void btnEnviar(View view){
        if (!validarCorreo()){
            txtCorreo.setError("El correo electrónico es inválido.");
        }
        else {

            if (ValidarVacios()){

                String cedula = txtCedula.getText().toString();
                String nombre = txtNombre.getText().toString();
                String fecha = txtFecha.getText().toString();
                String ciudad = txtCiudad.getText().toString();
                String correo = txtCorreo.getText().toString();
                String telefono = txtTelefono.getText().toString();
                //Para sacar el genero seleccionado
                String genero = rbMasculino.isChecked()?"Masculino":"Femenino";

                Intent intent = new Intent(MainActivity.this,MainActivityDatos.class);
                Bundle b = new Bundle();
                b.putString("Cedula",cedula);
                b.putString("Nombre",nombre);
                b.putString("Fecha",fecha);
                b.putString("Ciudad",ciudad);
                b.putString("Correo",correo);
                b.putString("Telefono",telefono);
                b.putString("Genero",genero);
                intent.putExtras(b);

                startActivity(intent);
                //Inicia la otra actividad
            }

        }
    }

    //Limpiar Formulario
    public void Limpiar(View view){
        txtCedula = (EditText) findViewById(R.id.txtCedula);
        txtNombre =(EditText) findViewById(R.id.txtNombre);
        txtFecha = (EditText) findViewById(R.id.txtFecha);
        txtCiudad = (EditText)findViewById(R.id.txtCiudad);
        txtCorreo = (EditText) findViewById(R.id.txtCorreo);
        txtTelefono = (EditText) findViewById(R.id.txtTeléfono);
        rbMasculino = (RadioButton) findViewById(R.id.rbMasculino);
        rbFemenino = (RadioButton) findViewById(R.id.rbFemenino);

        txtCedula.setText("");
        txtNombre.setText("");
        txtFecha.setText("");
        txtCiudad.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
        rbMasculino.setChecked(false);
        rbFemenino.setChecked(false);

        Toast.makeText(getApplicationContext(),"Formulario Limpiado",Toast.LENGTH_SHORT).show();
    }

}