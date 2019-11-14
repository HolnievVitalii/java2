package ru.geekbrains.java2.lesson1;

public interface Action {
    String run(int dist);
    String jump(int height);
    String swim(int dist);
    boolean atADistance();
    void info();
}
