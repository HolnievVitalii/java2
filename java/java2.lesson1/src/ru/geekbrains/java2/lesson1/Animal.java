package ru.geekbrains.java2.lesson1;

public class Animal implements Action {
    private String type;
    private String name;

    private int maxJumpH;
    private int maxRunD;
    private int maxSwimD;

    private boolean atDistance;

    public Animal(String type, String name, int maxJumpH, int maxRunD, int maxSwimD) {
        this.type = type;
        this.name = name;
        this.maxJumpH = maxJumpH;
        this.maxRunD = maxRunD;
        this.maxSwimD = maxSwimD;
        this.atDistance = true;
    }

    @Override
    public String run(int dist) {
        if (dist <= maxRunD) {
            return (type + " " + name + " coped with running!");
        } else {
            atDistance = false;
            return (type + " " + name + " did not cope with running!!!");
        }
    }

    @Override
    public String jump(int height) {
        if (height <= maxJumpH) {
            return (type + " " + name + " coped with the jump!");
        } else {
            atDistance = false;
            return (type + " " + name + " did not cope with jump!!!");
        }
    }

    @Override
    public String swim(int dist) {
        if (dist <= maxSwimD) {
            return (type + " " + name + " coped with the swim!");
    } else {
            atDistance = false;
            return (type + " " + name + " did not cope with swim!!!");
        }
    }

    @Override
    public boolean atADistance() {
        return atDistance;
    }

    @Override
    public void info() {
        System.out.println(type + " " + name + " " + atDistance);
    }
}
