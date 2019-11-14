package ru.geekbrains.java2.lesson1;

public class Wall extends Hurdle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    String perform(Action action) {
        return action.jump(height);
    }
}
