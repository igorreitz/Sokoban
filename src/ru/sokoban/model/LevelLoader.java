package ru.sokoban.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Загрузчик уровней
 *
 * @author Igor Reitz on 05.02.2019
 */
public class LevelLoader {
    private Path levels;
    private List<GameObjects> levelsList = new ArrayList<>();

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {
        parseFileWithLevels();
        if (level > 60)
            level = level % 10;
        return levelsList.get(level - 1);
    }

    private void parseFileWithLevels() {
        Set<Wall> walls = null;
        Set<Box> boxes = null;
        Set<Home> homes = null;
        GameObjects gameObjects;


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(levels.toFile()))) {
            String line = bufferedReader.readLine();
            int x = Model.FIELD_CELL_SIZE / 2;
            int y = Model.FIELD_CELL_SIZE / 2;

            while (line != null) {
                if (line.contains("*************************************")) {
                    x = Model.FIELD_CELL_SIZE / 2;
                    y = Model.FIELD_CELL_SIZE / 2;
                    walls = new HashSet<>();
                    boxes = new HashSet<>();
                    homes = new HashSet<>();

                } else if (line.contains("X") & !line.contains(":")) {
                    for (int i = 0; i < line.length(); i++) {
                        switch (line.charAt(i)) {
                            case ' ':
                                x += Model.FIELD_CELL_SIZE;
                                break;
                            case 'X':
                                walls.add(new Wall(x, y));
                                x += Model.FIELD_CELL_SIZE;
                                break;
                            case '*':
                                boxes.add(new Box(x, y));
                                x += Model.FIELD_CELL_SIZE;
                                break;
                            case '&':
                                boxes.add(new Box(x, y));
                                homes.add(new Home(x, y));
                                x += Model.FIELD_CELL_SIZE;
                                break;
                            case '.':
                                homes.add(new Home(x, y));
                                x += Model.FIELD_CELL_SIZE;
                                break;
                            case '@':
                                Player player = new Player(x, y);
                                gameObjects = new GameObjects(walls, boxes, homes, player);
                                levelsList.add(gameObjects);
                                x += Model.FIELD_CELL_SIZE;
                                break;
                        }
                    }
                    y += Model.FIELD_CELL_SIZE;
                    x = Model.FIELD_CELL_SIZE / 2;
                }


                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("Ошибка парсинга файла с уровнями");
        }


    }
}
