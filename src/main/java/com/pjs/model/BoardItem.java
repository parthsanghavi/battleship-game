package com.pjs.model;

import com.pjs.enums.BoardItemType;

public class BoardItem {

    private String name;
    private int size;
    private int x;
    private int y;
    private BoardItemType boardItemType;

    public BoardItem(String name, int size, int x, int y,BoardItemType boardItemType) {
        this.name = name;
        this.size = size;
        this.x = x;
        this.y = y;
        this.boardItemType = boardItemType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public BoardItemType getBoardItemType() {
        return boardItemType;
    }

    public void setBoardItemType(BoardItemType boardItemType) {
        this.boardItemType = boardItemType;
    }
}
