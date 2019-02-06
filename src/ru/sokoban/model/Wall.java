package ru.sokoban.model;

import java.awt.*;

/**
 * @author Igor Reitz on 05.02.2019
 */
public class Wall extends CollisionObject {
    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.CYAN);
        //graphics.drawRect(this.getX(),this.getY(),this.getWidth(),this.getHeight());
        graphics.fillRect(this.getX(),this.getY(),this.getWidth(),this.getHeight());
    }
}
