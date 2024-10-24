package com.pjs.strategy;

import com.pjs.model.Player;
import java.util.Deque;
import java.util.List;

public interface WinningStrategy {

    Player getWinner(Deque<Player> playerList);
}
