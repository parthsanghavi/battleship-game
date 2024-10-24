package com.pjs.model;

import com.pjs.exception.InvalidInputException;
import java.util.ArrayList;
import java.util.List;

public class Board {

    private final int rows;
    private final int columns;
    private final BoardItem[][] boardItems;
    private final List<Coordinate> allBombLocations;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.boardItems = new BoardItem[rows][columns];
        this.allBombLocations = new ArrayList<>();
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void addBoardItem(BoardItem boardItem) {

        validateBoardItemSpaceIsAvailable(boardItem);
        for (int i = boardItem.getX(); i <= boardItem.getX() + boardItem.getSize(); i++) {
            for (int j = boardItem.getY(); j <= boardItem.getY() + boardItem.getSize(); j++) {
                if (boardItems[i][j] != null) {
                    throw new InvalidInputException("Invalid input");
                }
                boardItems[i][j] = boardItem;
            }
        }
    }

    public void validateBoardItemSpaceIsAvailable(BoardItem boardItem) {
        int rightMostPoint = boardItem.getX() + boardItem.getSize();
        int belowMostPoint = boardItem.getY() + boardItem.getSize();

        if (rightMostPoint > rows - 1 || belowMostPoint > columns - 1) {
            throw new InvalidInputException("Invalid input. Exceeding the boundary of the board");
        }

        for (int i = boardItem.getX(); i <= boardItem.getSize(); i++) {
            for (int j = boardItem.getY(); j <= boardItem.getSize(); j++) {
                if (boardItems[i][j] != null) {
                    throw new InvalidInputException("Invalid input. There is already a " + boardItem.getBoardItemType().name() + " in this boundary");
                }
            }
        }
    }

    public void hitBoard(Coordinate coordinate) {
        System.out.println("Coordinate: " + coordinate.toString());
        allBombLocations.add(coordinate);
        if (boardItems[coordinate.getX()][coordinate.getY()] != null) {
            BoardItem boardItem = boardItems[coordinate.getX()][coordinate.getY()];
            System.out.println("Hit ship: " + boardItem.getName());
//            for (int i = 0; i <= rows - 1; i++) {
//                for (int j = 0; j <= columns - 1; j++) {
            for (int i = boardItem.getX(); i <= boardItem.getSize(); i++) {
                for (int j = boardItem.getY(); j <= boardItem.getSize(); j++) {
                    if (boardItems[i][j] != null && boardItems[i][j].getName().equals(boardItem.getName())) {
                        boardItems[i][j] = null;
                    }
                }
            }
        } else {
            System.out.println("Miss: ");
        }
    }

    public boolean validateCoordinate(Coordinate coordinate) {
        for (Coordinate coordinate1 : allBombLocations) {
            if (coordinate1.getX() == coordinate.getX() && coordinate1.getY() == coordinate.getY()) {
                return false;
            }
        }
        return true;
    }

    public boolean areAllShipsKilled() {
        for (int i = 0; i <= rows - 1; i++) {
            for (int j = 0; j <= columns - 1; j++) {
                if (boardItems[i][j] != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public void displayBoard() {
        for (int i = 0; i <= rows - 1; i++) {
            for (int j = 0; j <= columns - 1; j++) {
                if (boardItems[i][j] == null) {
                    System.out.print("-\t\t");
                } else {
                    System.out.print(boardItems[i][j].getName() + "\t");
                }
            }
            System.out.println();
        }
    }
}
