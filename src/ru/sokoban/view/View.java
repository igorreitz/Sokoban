package ru.sokoban.view;

import ru.sokoban.controller.Controller;
import ru.sokoban.controller.EventListener;
import ru.sokoban.model.GameObjects;

import javax.swing.*;

public class View extends JFrame {
    private Controller controller;
    private Field field;


    public void setEventListener(EventListener eventListener) {
        this.field.setEventListener(eventListener);
    }

    public View(Controller controller) {
        this.controller = controller;
    }

    public void init() {
        field = new Field(this);
        add(field);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("Сокобан");
        setVisible(true);
    }

    //будет обновлять представление (перерисовывать поле)
    public void update(){
        field.repaint();
    }

    public GameObjects getGameObjects(){
        return controller.getGameObjects();
    }

    public void completed(int level) {
        update();
        JOptionPane.showMessageDialog(this,"Уровень пройден");
        controller.startNextLevel();
    }
}
