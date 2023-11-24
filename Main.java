package javadevkit05;

/**
* Пять безмолвных философов сидят вокруг круглого стола, 
* перед каждым философом стоит тарелка спагетти.
* Вилки лежат на столе между каждой парой ближайших философов.
* Каждый философ может либо есть, либо размышлять.
* Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
* Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)
* Философ может взять только две вилки сразу, то есть обе вилки должны быть свободны
* Каждый философ должен поесть три раза
*/

public class Main {
    public static void main(String[] args) {
        Fork[] forks = new Fork[5];
        Philosopher[] philosophers = new Philosopher[5];
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            forks[i] = new Fork(i);
        }

        for (int i = 0; i < 5; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % 5];
            philosophers[i] = new Philosopher(i, leftFork, rightFork);
            threads[i] = new Thread(philosophers[i]);
            threads[i].start();
        }
    }
}