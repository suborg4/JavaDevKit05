package javadevkit05;

public class Philosopher implements Runnable {
    private int id;
    private Fork leftFork;
    private Fork rightFork;
    private int eatCount;

    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.eatCount = 0;
    }

    @Override
    public void run() {
        while (eatCount < 3) {
            think();
            eat();
        }
    }

    private void think() {
        System.out.println("Philosopher " + id + " is thinking");
        // размышления философа
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void eat() {
        System.out.println("Philosopher " + id + " is trying to eat");

        synchronized (leftFork) {
            System.out.println("Philosopher " + id + " picked up left fork");

            synchronized (rightFork) {
                System.out.println("Philosopher " + id + " picked up right fork");

                System.out.println("Philosopher " + id + " is eating");
                // прием пищи философа
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Philosopher " + id + " put down right fork");
            }

            System.out.println("Philosopher " + id + " put down left fork");
        }

        eatCount++;
    }
}