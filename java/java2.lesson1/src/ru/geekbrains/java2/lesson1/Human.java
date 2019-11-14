package ru.geekbrains.java2.lesson1;

public class Human implements Action {
    private String name;
    private int maxRunD;
    private int maxJumpH;
    private int maxSwimD;
    private boolean active;

    public Human(String name) {
        this.name = name;
        this.maxRunD = 4000;
        this.maxJumpH = 7;
        this.maxSwimD = 200;
        this.active = true;
    }

    @Override
    public String run(int dist) {
        if (dist <= maxRunD) {
            return (name + " coped with running!");
        } else {
            active = false;
            return (name + " did not cope with running!!!");
        }
    }

    @Override
    public String jump(int height) {
        if (height <= maxJumpH) {
            return (name + " coped with the jump!");
        } else {
            active = false;
            return (name + " did not cope with jump!!!");
        }
    }

    @Override
    public String swim(int dist) {
        if (dist <= maxSwimD) {
            return (name + " coped with the swim!");
        } else {
            active = false;
            return (name + " did not cope with swim!!!");
        }
    }

    @Override
    public boolean atADistance() {
        return active;
    }

    @Override
    public void info() {
        System.out.println(name + " is active: " + active);
    }

}
