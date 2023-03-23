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
    private String playersOneGame;
    private String playersTwoGame,playerAux;
    private ArrayList game = new ArrayList();
    private ListActivity info = new ListActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        Bundle info = getIntent().getExtras();
        players = new String[]{info.getString("Jugador 1"), info.getString("Jugador 2")};
        playersOneGame = "";
        playersTwoGame = "";
        playerAux="";
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
                if (playersOneGame.length() <= sizeMemory) {
                    playersOneGame += letter;
                    if (playersOneGame.length() == sizeMemory)
                        changeTurn();
                }
                break;
            case 1:
                if (playersTwoGame.length() <= sizeMemory) {
                    playersTwoGame += letter;
                    if (playersTwoGame.length() == sizeMemory)
                        changeTurn();
                }
                break;
        }
    }

    private void changeTurn() {
        switch (turn) {
            case 0:
                if (playerAux != "") {
                    if (playersOneGame.substring(0, playerAux.length()).contentEquals(playerAux)) {
                        turn = 1;
                        updateTurnText();
                        sizeMemory++;
                        playerAux = playersOneGame;
                        playersOneGame = "";
                    } else {
                        textPlayer1.setText(players[0] + " has perdido");
                        textPlayer2.setText(players[1] + " HAS GANADO");
                        //info.setWinsTwo(info.getWinsTwo());
                    }
                } else {
                    playerAux = playersOneGame;
                    playersOneGame = "";
                    turn = 1;
                    sizeMemory++;
                    updateTurnText();
                }
                break;
            case 1:
                if (playerAux != ""){
                    if (playersTwoGame.substring(0, playerAux.length()).equals(playerAux)) {
                        turn = 0;
                        updateTurnText();
                        sizeMemory++;
                        playerAux = playersTwoGame;
                        playersTwoGame = "";
                    } else {
                        textPlayer1.setText(players[0] + " HAS GANADO");
                        textPlayer2.setText(players[1] + " has perdido");
                        //info.setWinsOne(info.getWinsOne() + 1);
                    }
                } else {
                    playerAux = playersTwoGame;
                    playersTwoGame = "";
                    turn = 0;
                    sizeMemory++;
                    updateTurnText();
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