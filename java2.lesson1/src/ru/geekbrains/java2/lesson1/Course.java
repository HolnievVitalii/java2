package ru.geekbrains.java2.lesson1;

public class Course {
    private Hurdle[] hurdles;

    public Course(Hurdle... hurdles) {
        this.hurdles = hurdles;
    }

    void doIt(Team team) {
        Action[] actions = team.getActions();
        if (actions.length == 0) {
            System.out.println("There is no one =(");
            return;
        }
        for (Action a: actions) {
            for (Hurdle h: hurdles) {
                team.setResults(h.perform(a));
                if (!a.atADistance()) {
                    break;
                }
            }
        }
    }

}
