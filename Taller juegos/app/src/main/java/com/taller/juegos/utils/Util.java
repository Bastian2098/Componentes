package com.taller.juegos.utils;

import java.util.Random;

public class Util {

    public static int getPlayerTurn(String[] players) {
        Random random = new Random();
        int index = random.nextInt(players.length);
        return index;
    }

}