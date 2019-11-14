package ru.geekbrains.java2.lesson1;

public class Team {
    private String name;
    private StringBuilder results;
    private Action[] actions;

    public Team(String name,Action... actions) {
        this.name = name;
        this.results = new StringBuilder();
        this.actions = actions;
    }

    public String getName() {
        return name;
    }

    public Action[] getActions() {
        return actions;
    }

    public void setResults(String result) {
        results.append(result).append("\n");
    }

    public void showResults() {
        System.out.println("Team: " + name + ", it's result - ");
        System.out.print(results);
    }

}
