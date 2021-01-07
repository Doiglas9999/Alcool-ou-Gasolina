package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPreçoAlcool;
    private TextInputEditText editPreçoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPreçoAlcool   = findViewById(R.id.editPreçoAlcool);
        editPreçoGasolina = findViewById(R.id.editPreçoGasolina);
        textResultado     = findViewById(R.id.textResultado);

    }

    public void calcularPreço(View view){

        String preçoAlcool = editPreçoAlcool.getText().toString();
        String preçoGasolina = editPreçoGasolina.getText().toString();

        boolean camposValidados = validarCampos( preçoAlcool, preçoGasolina);

        if (camposValidados){

            Double valorAlcool = Double.parseDouble(preçoAlcool);
            Double valorGasolina = Double.parseDouble(preçoGasolina);

            if ( (valorAlcool/valorGasolina) >= 0.7){
                textResultado.setText("É melhor utilizar Gasolina");
            }else{
                textResultado.setText("É melhor utilizar Álcool");
            }
        }
    }

    public Boolean validarCampos (String pAlcool, String pGasolina){

        boolean camposValidados = true;

        if ( pAlcool == null || pAlcool.equals("") ){
            camposValidados = false;
            textResultado.setText("Favor preencher preço do Alcool");
        }

        if ( pGasolina == null || pGasolina.equals("") ){
            camposValidados = false;
            textResultado.setText("Favor preencher preço da Gasolina");
        }

        return camposValidados;
    }

}