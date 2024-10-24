package com.pjs.strategy;

import com.pjs.model.Board;
import com.pjs.model.Coordinate;
import com.pjs.model.Player;
import java.util.Scanner;

public class InputCoordinateAndFireStrategy implements FireStrategy {

    @Override
    public void fire(Player player) {
        int x;
        int y;
        Scanner scanner = new Scanner(System.in);
        Board playerBoard = player.getBoard();
        while (true) {
            System.out.println("Enter coordinate to fire as x,y:");
            String s = scanner.nextLine();
            String[] values = s.split(",");
            x = Integer.parseInt(values[0]);
            y = Integer.parseInt(values[1]);
            boolean areValid = playerBoard.validateCoordinate(new Coordinate(x, y));
            if (areValid) {
                break;
            } else {
                System.out.println("Coordinate already used please try again !!");
            }
        }
        playerBoard.hitBoard(new Coordinate(x, y));
    }
}
