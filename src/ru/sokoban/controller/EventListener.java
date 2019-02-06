package ru.sokoban.controller;

import ru.sokoban.model.Direction;

/**
 * В процессе работы игры, будут возникать различные события. Cоздадим интерфейс слушателя событий EventListener.
 * Его должен реализовывать каждый класс, который хочет обрабатывать события. А классы, которые будут генерировать события, будут вызывать методы этого интерфейса.
 *
 * @author Igor Reitz on 05.02.2019
 */
public interface EventListener {
    void move(Direction direction);// - передвинуть объект в определенном направлении.

    void restart();// - начать заново текущий уровень.

    void startNextLevel(); // - начать следующий уровень.

    void levelCompleted(int level); // - уровень с номером level завершён.
}
