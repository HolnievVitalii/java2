package ru.geekbrains.java2.lesson1;

public class Track extends Hurdle {
    private int length;

    public Track(int length) {
        this.length = length;
    }

    @Override
    String perform(Action action) {
        return action.run(length);
    }
}
