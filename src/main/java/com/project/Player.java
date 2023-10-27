package com.project;

public class Player {
    private String playerName;
    private int scoring;

    public Player(String name) {
        playerName = name;
        scoring = 0;
        System.out.println("jugador " + playerName + "creado");
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return scoring;
    }

    public void addScore(int score) {
        scoring = scoring + score;
    }
}
