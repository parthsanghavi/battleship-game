package com.pjs.strategy;

import com.pjs.model.Player;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class DefaultWinningStrategy implements WinningStrategy {


    @Override
    public Player getWinner(Deque<Player> playerList) {
        List<Player> alivePlayers = new ArrayList<>();
        for (Player player : playerList) {
            if (!player.areAllShipsKilled()) {
                alivePlayers.add(player);
            }
        }
        if (alivePlayers.size() == 1) {
            return alivePlayers.get(0);
        }
        return null;
    }
}
