package ru.geekbrains.java2.lesson1;

public class Pool extends Hurdle {
    private int length;

    public Pool(int length) {
        this.length = length;
    }

    @Override
    String perform(Action action) {
        return action.swim(length);
    }
}
