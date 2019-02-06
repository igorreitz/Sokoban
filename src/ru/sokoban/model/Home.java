package ru.sokoban.model;

import java.awt.*;

/**
 * @author Igor Reitz on 05.02.2019
 */
public class Home extends GameObject{
    public Home(int x, int y) {
        super(x, y);
        this.setHeight(20);
        this.setWidth(20);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.drawOval(this.getX(),this.getY(),this.getWidth(),this.getHeight());
    }
}
