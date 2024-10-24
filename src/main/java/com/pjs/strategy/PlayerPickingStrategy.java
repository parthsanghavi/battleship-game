package com.pjs.strategy;

import com.pjs.model.Player;
import java.util.Deque;
import java.util.List;

public interface PlayerPickingStrategy {

    Player pickPlayerToTarget(List<Player> players);

}
