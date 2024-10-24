package com.pjs;

import com.pjs.model.Board;
import com.pjs.model.Player;
import com.pjs.model.ShipBoardItem;
import com.pjs.strategy.InputCoordinateAndFireStrategy;
import com.pjs.strategy.RandomPlayerPickingStrategy;
import com.pjs.strategy.DefaultWinningStrategy;
import com.pjs.strategy.FireStrategy;
import com.pjs.strategy.PlayerPickingStrategy;
import com.pjs.strategy.RandomCoordinateFireStrategy;
import com.pjs.strategy.WinningStrategy;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BattleshipGame {

    private final Deque<Player> players;
    private final PlayerPickingStrategy playerPickingStrategy;
    private final FireStrategy fireStrategy;
    private final WinningStrategy winningStrategy;

    public BattleshipGame() {
        this.players = new LinkedList<>();
        this.playerPickingStrategy = new RandomPlayerPickingStrategy();
        this.fireStrategy = new InputCoordinateAndFireStrategy();
        this.winningStrategy = new DefaultWinningStrategy();
    }

    public void initializeGame(int n) {
        int rows = n ;
        int columns = n / 2;
        Board player1board = new Board(rows, columns);
        Player player1 = new Player("P1", player1board);
        Board player2board = new Board(rows, columns);
        Player player2 = new Player("P2", player2board);
        players.add(player1);
        players.add(player2);
    }

    public void addShip() {
        Scanner scanner = new Scanner(System.in);
        for (Player player : players) {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Adding Ship: " + i + " for Player: " + player.getId());
                System.out.println("Enter the size and x,y co-ordinate of ship as size,x,y: ");
                String s = scanner.nextLine();
                String[] values = s.split(",");
                int size = Integer.parseInt(values[0]);
                int x = Integer.parseInt(values[1]);
                int y = Integer.parseInt(values[2]);
                ShipBoardItem shipBoardItem = new ShipBoardItem(player.getId() + "-SH" + i, size, x, y);
                player.getBoard().addBoardItem(shipBoardItem);
            }
        }
    }

    public void startGame() {
        System.out.println("Starting the game");
        while (true) {

            //check whose turn now
            Player playerTurn = findPlayerTurn();

            //get all opponents for current player
            List<Player> opponents = playerTurn.getOpponents(players);

            //get player to target
            Player targetPlayer = playerPickingStrategy.pickPlayerToTarget(opponents);

            System.out.println("Player playing now: " + playerTurn.getId() + " Target player: " + targetPlayer.getId());
            //fire on that player's board
            fireStrategy.fire(targetPlayer);

            //check if any winner
            Player winner = winningStrategy.getWinner(players);
            System.out.println("==============================================");
            System.out.println("Displaying board for target player: " + targetPlayer.getId());
            System.out.println("----------------------------------------------");
            targetPlayer.getBoard().displayBoard();
            System.out.println("==============================================");
            if (winner != null) {
                System.out.println("Winner: " + winner.getId());
                break;
            }
        }
    }

    private Player findPlayerTurn() {

        Player playerTurns = players.removeFirst();
        players.addLast(playerTurns);
        return playerTurns;
    }

    public void viewBoard() {
        for (Player player : players) {
            System.out.println("==============================================");
            System.out.println("Displaying board for player: " + player.getId());
            System.out.println("----------------------------------------------");
            player.getBoard().displayBoard();
            System.out.println("==============================================");
        }
    }
}
