package ru.sokoban.model;

import java.awt.*;

/**
 * @author Igor Reitz on 05.02.2019
 */
public class Player extends CollisionObject implements Movable{

    public Player(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.yellow);
        //graphics.drawOval(this.getX(),this.getY(),this.getWidth(),this.getHeight());
        graphics.fillOval(this.getX(),this.getY(),this.getWidth(),this.getHeight());

    }

    @Override
    public void move(int x, int y) {
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }
}
