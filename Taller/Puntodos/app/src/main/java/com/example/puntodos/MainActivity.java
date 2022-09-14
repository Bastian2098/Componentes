package com.example.puntodos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText fieldLadoA, fieldLadoB, fieldLadoC;
    private TextView labelResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fieldLadoA = findViewById(R.id.fieldLadoA);
        fieldLadoB = findViewById(R.id.fieldLadoB);
        fieldLadoC = findViewById(R.id.fieldLadoC);
        labelResultado = findViewById(R.id.labelResultado);
    }

    public void clasificar(View view) {
        if (fieldLadoA.getText().length() != 0 && fieldLadoB.getText().length() != 0 && fieldLadoC.getText().length() != 0) {
            boolean AB = Integer.parseInt(fieldLadoA.getText().toString()) == Integer.parseInt(fieldLadoB.getText().toString());
            boolean AC = Integer.parseInt(fieldLadoA.getText().toString()) == Integer.parseInt(fieldLadoC.getText().toString());
            boolean BC = Integer.parseInt(fieldLadoB.getText().toString()) == Integer.parseInt(fieldLadoC.getText().toString());
            if (AB == true && AC == true && BC == true)
                labelResultado.setText("Triangulo equilatero");
            else if (AB == false && AC == false && BC == false)
                labelResultado.setText("Triangulo escaleno");
            else
                labelResultado.setText("Triangulo isosceles");
        } else
            labelResultado.setText("Faltan lados");
    }

}