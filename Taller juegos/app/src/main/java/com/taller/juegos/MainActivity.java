package com.taller.juegos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText fieldJugador1, fieldJugador2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fieldJugador1 = findViewById(R.id.editTextTextPersonName);
        fieldJugador2 = findViewById(R.id.editTextTextPersonName2);
        Button jugarButton = findViewById(R.id.button);
        jugarButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ListActivity.class);
            intent.putExtra("Jugador 1", fieldJugador1.getText().toString());
            intent.putExtra("Jugador 2", fieldJugador2.getText().toString());
            startActivity(intent);
        });

    }

}