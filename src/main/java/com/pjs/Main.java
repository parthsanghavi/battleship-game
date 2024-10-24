package com.pjs;

public class Main {

    public static void main(String[] args) {
        BattleshipGame battleshipGame = new BattleshipGame();
        battleshipGame.initializeGame(10);
        battleshipGame.addShip();
        battleshipGame.viewBoard();
        battleshipGame.startGame();
    }
}