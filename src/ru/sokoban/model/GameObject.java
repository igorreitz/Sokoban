package ru.sokoban.model;

import java.awt.*;

/**
 * @author Igor Reitz on 05.02.2019
 */
public abstract class GameObject {
    private int x, y, width, height;

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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
        this.height = Model.FIELD_CELL_SIZE;
        this.width = Model.FIELD_CELL_SIZE;
    }

    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // Этот метод будет реализован в каждом типе игровых объектов по-своему.
    // Другими словами, каждый тип игровых объектов будет знать, как он должен рисоваться и будет сам себя рисовать в графический контекст graphics.
    // Graphics - это абстрактный класс из библиотеки java.awt.
    public abstract void draw(Graphics graphics);
}
