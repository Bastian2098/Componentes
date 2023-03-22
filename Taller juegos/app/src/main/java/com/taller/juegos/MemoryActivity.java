package com.taller.juegos;

import static com.taller.juegos.utils.Util.getPlayerTurn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MemoryActivity extends AppCompatActivity {

    private TextView textPlayer1, textPlayer2;
    private String[] players;
    private int turn, sizeMemory = 1;
    private ArrayList<ArrayList> playersGame;
    private ArrayList game = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        Bundle info = getIntent().getExtras();
        players = new String[]{info.getString("Jugador 1"), info.getString("Jugador 2")};
        playersGame = new ArrayList<ArrayList>();
        playersGame.add(new ArrayList());
        playersGame.add(new ArrayList());
        turn = getPlayerTurn(players);
        textPlayer1 = findViewById(R.id.labelMemoryPlayer1);
        textPlayer2 = findViewById(R.id.labelMemoryPlayer2);
        updateTurnText();
        Button buttonA = findViewById(R.id.buttonA);
        Button buttonB = findViewById(R.id.buttonB);
        Button buttonC = findViewById(R.id.buttonC);
        Button buttonD = findViewById(R.id.buttonD);
        Button buttonE = findViewById(R.id.buttonE);
        Button buttonF = findViewById(R.id.buttonF);
        Button buttonG = findViewById(R.id.buttonG);
        Button buttonH = findViewById(R.id.buttonH);
        Button buttonI = findViewById(R.id.buttonI);
        buttonA.setOnClickListener(view -> {
            /*if (turn == 0 && sizeMemory <= playersGame.get(1).size() + 1) {
                play("A");
            } else if (turn == 1 && sizeMemory <= playersGame.get(0).size() + 1) {
                play("A");
                changeTurn();
            } else {

            }*/
            play("A");
        });
        buttonB.setOnClickListener(view -> {
            play("B");
        });
        buttonC.setOnClickListener(view -> {
            play("C");
        });
        buttonD.setOnClickListener(view -> {
            play("D");
        });
        buttonE.setOnClickListener(view -> {
            play("E");
        });
        buttonF.setOnClickListener(view -> {
            play("F");
        });
        buttonG.setOnClickListener(view -> {
            play("G");
        });
        buttonH.setOnClickListener(view -> {
            play("H");
        });
        buttonI.setOnClickListener(view -> {
            play("I");
        });
    }

    public void play(String letter) {
        switch (turn) {
            case 0:
                if (playersGame.get(0).size() <= sizeMemory) {
                    playersGame.get(0).add(letter);
                    if (playersGame.get(0).size() == sizeMemory)
                        changeTurn();
                }
                break;
            case 1:
                if (playersGame.get(1).size() <= sizeMemory) {
                    playersGame.get(1).add(letter);
                    if (playersGame.get(1).size() == sizeMemory)
                        changeTurn();
                }
                break;
        }
    }

    private void changeTurn() {
        switch (turn) {
            case 0:
                if (playersGame.get(0).subList(0, sizeMemory - 1).equals(game)) {
                    turn = 1;
                    updateTurnText();
                    sizeMemory++;
                    game = playersGame.get(0);
                    playersGame.get(0).clear();
                } else {
                    textPlayer1.setText(players[0] + " HAS GANADO");
                    textPlayer2.setText(players[1] + " has perdido");
                }
                break;
            case 1:
                if (playersGame.get(1).subList(0, sizeMemory - 1).equals(game)) {
                    turn = 0;
                    updateTurnText();
                    sizeMemory++;
                    game = playersGame.get(1);
                    playersGame.get(1).clear();
                } else {
                    textPlayer1.setText(players[0] + " has perdido");
                    textPlayer2.setText(players[1] + " HAS GANADO");
                }
                break;
        }
    }

    private void updateTurnText() {
        switch (turn) {
            case 0:
                textPlayer1.setText(players[0] + " es tu turno");
                textPlayer2.setText(players[1] + ", es turno de " + players[0]);
                break;
            case 1:
                textPlayer1.setText(players[0] + ", es turno de " + players[1]);
                textPlayer2.setText(players[1] + " es tu turno");
                break;
        }
    }

}