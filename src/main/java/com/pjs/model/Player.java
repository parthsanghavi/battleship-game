package com.pjs.model;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Player {

    String id;
    Board board;

    public Player(String id, Board board) {
        this.id = id;
        this.board = board;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getOpponents(Deque<Player> players) {
        List<Player> opponents = new ArrayList<>();
        for (Player player : players) {
            if (!player.getId().equals(getId())) {
                opponents.add(player);
            }
        }
        return opponents;
    }

    public void hitBoard(Coordinate coordinate) {
        board.hitBoard(coordinate);
    }

    public boolean areAllShipsKilled() {
        return board.areAllShipsKilled();
    }
}
