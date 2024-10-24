package com.pjs.model;

import com.pjs.enums.BoardItemType;

public class ShipBoardItem extends BoardItem {

    public ShipBoardItem(String name, int size, int x, int y) {
        super(name, size, x, y, BoardItemType.SHIP);
    }
}
