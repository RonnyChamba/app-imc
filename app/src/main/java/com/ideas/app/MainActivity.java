package com.ideas.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.ideas.app.entidades.Persona;

/**
 * Implementar  interfaz OnClickListener para procesar los eventos click de
 * los Button
 */
public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    /**
     * Definir variables que se enlazaran con los widgets de la vista
     */
    private EditText txtNombre;
    private EditText txtApellido;
    private EditText txtPeso;
    private EditText txtEdad;
    private EditText txtEstatura;
    private EditText txtImc;

    private Button btnCalcular;
    private Button btnSalir;

    private RadioGroup grupo;

    private Persona persona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();
    }


    private void initWidgets() {

        btnCalcular = findViewById(R.id.btnCalcular);
        // Poner a la escucha los botones, pasamos la propia clase(this), está implementa OnClickListener
        btnCalcular.setOnClickListener(this);

        btnSalir = findViewById(R.id.btnSalir);
        btnSalir.setOnClickListener(this);

        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtEstatura = findViewById(R.id.txtEstatura);
        txtPeso = findViewById(R.id.txtPeso);
        txtEdad= findViewById(R.id.txtEdad);
        txtImc = findViewById(R.id.txtImc);

        grupo = findViewById(R.id.radioGrupo);
    }

    @Override
    public void onClick(View view) {

        // Verificar que tipo de widget desencadeno el evento: Button o Otro
        if (view instanceof Button) clickBotones(view);
    }
    /**
     * Método verifica que Button fue pulsado
     *
     * @param view
     */
    private void clickBotones(View view) {

        if (view.getId() == btnCalcular.getId()) procesarDatos();
        else if (view.getId() == btnSalir.getId()) finish();
    }

    /**
     * Método utilizado para obtener los datos ingresdos en los distintos widget de la vista
     */
    private void procesarDatos() {

        if (validarVaciosYNumericos()) {

            persona = new Persona();

            persona.setNombre(txtNombre.getText().toString());
            persona.setApelllido(txtApellido.getText().toString());
            persona.setEdad(Integer.parseInt(txtEdad.getText().toString()));
            persona.setEstatura(Double.parseDouble(txtEstatura.getText().toString()));
            persona.setPeso(Double.parseDouble(txtPeso.getText().toString()));
            persona.setSexo(getSexo());
            calcularImc();
        }
    }

    private void calcularImc() {
        double  estatura= persona.getEstatura()/100;
        double indiceMasaCorporal = persona.getPeso()/  estatura * estatura;
        persona.setIndiceMasaCorporal(indiceMasaCorporal);
        mostrarMensajes();
    }

    private void mostrarMensajes(){

        txtImc.setText(String.format("%s %s: %s %s", persona.getNombre(), persona.getApelllido(), persona.getIndiceMasaCorporal(), getEstadoImc()));

    }

    private String getEstadoImc(){

        String smsEstado;
        if (persona.getIndiceMasaCorporal() < 18.5) smsEstado = "Bajo";
        else if (persona.getIndiceMasaCorporal() < 25) smsEstado = "Normal";
        else if (persona.getIndiceMasaCorporal() < 30) smsEstado = "Sobrepeso";
        else smsEstado = "obesidad";

        return smsEstado;

    }
    private String getSexo(){

        if (grupo.getCheckedRadioButtonId() == R.id.radioHombre) {
            return "Hombre";
        }
        else if (grupo.getCheckedRadioButtonId() == R.id.radioMujer) {
            return "Mujer";
        }
        if (grupo.getCheckedRadioButtonId() == R.id.radioOtro) {
            return "Otro";
        }else return "Nada";
    }

    /**
     * Método valida que los campos  {@link #txtEdad} {@link #txtEstatura}, {@link #txtPeso} no esten vacios,
     * además que los valores ingresados sean númericos.
     *
     * @return true: continua con el procesamiento de los datos<br>
     * false: No procesa los datos y muestra mensajes de alerta
     */
    private boolean validarVaciosYNumericos() {

        boolean estado = true;

        if (txtPeso.getText().toString().isEmpty()   ||
                txtEstatura.getText().toString().isEmpty()
                || txtEdad.getText().toString().isEmpty()) {
            Toast.makeText(this, "Peso, Estatura y Edad son obligatorios", Toast.LENGTH_SHORT).show();
            estado = false;
        }

        if (estado) {

            if (!txtEstatura.getText().toString().matches("^[0-9]+([.][0-9]{1,2})?$")) {
                Toast.makeText(this, "Formato incorrecto Estatura", Toast.LENGTH_SHORT).show();
                estado = false;
            }

            // ^[\\d]+(.[\\d]+)?"
            if (!txtPeso.getText().toString().matches("^[0-9]+([.][0-9]{1,2})?$")) {
                Toast.makeText(this, "Formato incorrecto Peso", Toast.LENGTH_SHORT).show();
                estado = false;
            }

            if (!txtEdad.getText().toString().matches("[\\d]+")) {
                Toast.makeText(this, "Formato incorrecto Edad", Toast.LENGTH_SHORT).show();
                estado = false;
            }


        }

        return estado;

    }




}