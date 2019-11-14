package ru.geekbrains.java2.lesson1;

public class Main {
    public static void main(String[] args) {
        Course c = new Course(new Track(900), new Wall(4),new Pool(30)); // Create an hurdle course
        Team team = new Team("First squad", new Human("Alex"), new Cat("Jovani"), new Dog("Phobos")); // Create a team
        c.doIt(team); // We ask the team to pass the hurdle course
        team.showResults(); // Show results
    }
}
