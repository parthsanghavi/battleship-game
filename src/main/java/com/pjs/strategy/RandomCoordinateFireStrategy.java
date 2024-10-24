package com.pjs.strategy;

import com.pjs.model.Board;
import com.pjs.model.Coordinate;
import com.pjs.model.Player;
import java.util.concurrent.ThreadLocalRandom;

public class RandomCoordinateFireStrategy implements FireStrategy {

    @Override
    public void fire(Player player) {
        Board playerBoard = player.getBoard();
        int x;
        int y;
        while (true) {
            x = ThreadLocalRandom.current().nextInt(0, playerBoard.getRows() - 1);
            y = ThreadLocalRandom.current().nextInt(0, playerBoard.getColumns() - 1);
            boolean areValid = playerBoard.validateCoordinate(new Coordinate(x, y));
            if (areValid) {
                break;
            }
        }
        playerBoard.hitBoard(new Coordinate(x, y));
    }
}
