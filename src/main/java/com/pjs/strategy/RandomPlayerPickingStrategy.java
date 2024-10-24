package com.pjs.strategy;

import com.pjs.model.Player;
import java.util.List;

public class RandomPlayerPickingStrategy implements PlayerPickingStrategy {

    @Override
    public Player pickPlayerToTarget(List<Player> players) {
        return players.get(0);
    }
}
