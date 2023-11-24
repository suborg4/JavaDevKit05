package javadevkit05;

public class Fork {
    private int id;
    private boolean isAvailable;

    public Fork(int id) {
        this.id = id;
        this.isAvailable = true;
    }

    public synchronized void pickUp() throws InterruptedException {
        while (!isAvailable) {
            wait();
        }
        isAvailable = false;
    }

    public synchronized void putDown() {
        isAvailable = true;
        notifyAll();
    }
}