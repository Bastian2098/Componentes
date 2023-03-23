package com.taller.juegos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {

    private int winsOne, winsTwo;

    public ListActivity() {
        this.winsOne = 0;
        this.winsTwo = 0;
    }

    public int getWinsOne() {
        return winsOne;
    }

    public int getWinsTwo() {
        return winsTwo;
    }

    public void setWinsOne(int winsOne) {
        this.winsOne = winsOne;
    }

    public void setWinsTwo(int winsTwo) {
        this.winsTwo = winsTwo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Bundle info = getIntent().getExtras();
        String namePlayer1 = info.getString("Jugador 1");
        String namePlayer2 = info.getString("Jugador 2");
        TextView textJugador1 = findViewById(R.id.textView3);
        TextView textJugador2 = findViewById(R.id.textView4);
        textJugador1.setText(namePlayer1);
        textJugador2.setText(namePlayer2);
        Button buttonMemory = findViewById(R.id.button2);
        Button buttonTriqui = findViewById(R.id.button3);
        Button buttonCreditos = findViewById(R.id.button4);
        buttonMemory.setOnClickListener(view -> {
            Intent intent = new Intent(ListActivity.this, MemoryActivity.class);
            intent.putExtra("Jugador 1", namePlayer1);
            intent.putExtra("Jugador 2", namePlayer2);
            startActivity(intent);
        });
        buttonTriqui.setOnClickListener(view -> {
            Intent intent = new Intent(ListActivity.this, TriquiActivity.class);
            intent.putExtra("Jugador 1", namePlayer1);
            intent.putExtra("Jugador 2", namePlayer2);
            startActivity(intent);
        });
        buttonCreditos.setOnClickListener(view -> {
            Intent intent = new Intent(ListActivity.this, CreditsActivity.class);
            startActivity(intent);
        });

    }

}