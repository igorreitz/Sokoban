package ru.sokoban.model;

/**
 * @author Igor Reitz on 05.02.2019
 */
public abstract class CollisionObject extends GameObject {
    public CollisionObject(int x, int y) {
        super(x, y);
    }

    //Этот метод должен возвращаться true, если при перемещении текущего объекта в направлении direction на FIELD_CELL_SIZE произойдет столкновение с объектом gameObject, переданным в качестве параметра.
    //Иначе - возвращать false. Столкновением считать совпадение координат x и y.
    public boolean isCollision(GameObject gameObject, Direction direction) {

        switch (direction) {
            case UP: return getY() - Model.FIELD_CELL_SIZE == gameObject.getY()
                    && getX() == gameObject.getX();

            case DOWN: return getY() + Model.FIELD_CELL_SIZE == gameObject.getY()
                    && getX() == gameObject.getX();

            case LEFT: return getX() - Model.FIELD_CELL_SIZE == gameObject.getX()
                    && getY() == gameObject.getY();

            case RIGHT: return getX() + Model.FIELD_CELL_SIZE == gameObject.getX()
                    && getY() == gameObject.getY();
        }

        return false;
    }
}
