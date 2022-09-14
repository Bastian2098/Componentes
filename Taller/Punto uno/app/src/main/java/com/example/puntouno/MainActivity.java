package com.example.puntouno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumber;
    private RadioButton radioBinario, radioOctal, radioHexa;
    private Button buttonConvertir;
    private TextView labelResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNumber = findViewById(R.id.editTextNumber);
        radioBinario = findViewById(R.id.radioBinario);
        radioOctal = findViewById(R.id.radioOcta);
        radioHexa = findViewById(R.id.radioHexa);
        buttonConvertir = findViewById(R.id.buttonConvertir);
        labelResultado = findViewById(R.id.labelResultado);
    }

    public void convertir(View view) {
        if (radioBinario.isChecked()) {
            labelResultado.setText(aBinario(editTextNumber.getText().toString()));
        }
        else if(radioOctal.isChecked()) {
            labelResultado.setText(aOcta(editTextNumber.getText().toString()));
        }
        else if(radioHexa.isChecked()) {
            labelResultado.setText(aHexa(editTextNumber.getText().toString()));
        }
    }

    public String aBinario(String numero) {
        int decimal = Integer.parseInt(numero);
        String binario = new String();
        String base = "00000000";
        while (decimal != 0) {
            if (decimal % 2 == 0) {
                binario += "0";
                decimal /= 2;
            }
            else {
                binario += "1";
                decimal /= 2;
            }
        }
        StringBuilder builder = new StringBuilder(binario);
        return builder.reverse().toString();
    }

    public String aOcta(String numero) {
        int decimal = Integer.parseInt(numero);
        String octal = new String();
        while (decimal != 0) {
            octal += String.valueOf(decimal % 8);
            decimal /= 8;
        }
        StringBuilder builder = new StringBuilder(octal);
        return builder.reverse().toString();
    }

    public String aHexa(String numero) {
        int decimal = Integer.parseInt(numero);
        String hexadecimal = new String();
        while (decimal != 0) {
            if (decimal % 16 > 9) {
                hexadecimal += hexaValues(decimal % 16);
            } else {
                hexadecimal += String.valueOf(decimal % 16);
            }
            decimal /= 16;
        }
        StringBuilder builder = new StringBuilder(hexadecimal);
        return builder.reverse().toString();
    }

    private String hexaValues(int numero) {
        String hexaValue = new String();
        switch (numero) {
            case 10:
                hexaValue = "A";
                break;
            case 11:
                hexaValue = "B";
                break;
            case 12:
                hexaValue = "C";
                break;
            case 13:
                hexaValue = "D";
                break;
            case 14:
                hexaValue = "E";
                break;
            case 15:
                hexaValue = "F";
                break;
            default:
                hexaValue = "";
                break;
        }
        return hexaValue;
    }

}