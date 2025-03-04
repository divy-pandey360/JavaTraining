import java.lang.Thread;
import java.lang.Runnable;

class Printer {
    private static final int MAX_COUNT = 100;
    private int counter = 0;
    private boolean turn = true;

    public synchronized void printPing() {
        while (counter < MAX_COUNT) {
            while (!turn) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            if (counter < MAX_COUNT) {
                System.out.println("Ping");
                counter++;
                turn = false;
                notifyAll();
            }
        }
    }

    public synchronized void printPong() {
        while (counter < MAX_COUNT) {
            while (turn) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            if (counter < MAX_COUNT) {
                System.out.println("Pong");
                counter++;
                turn = true;
                notifyAll();
            }
        }
    }
}

class Ping implements Runnable {
    private final Printer printer;

    public Ping(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.printPing();
    }
}

class Pong implements Runnable {
    private final Printer printer;

    public Pong(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.printPong();
    }
}

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread threadA = new Thread(new Ping(printer));
        Thread threadB = new Thread(new Pong(printer));

        threadA.start();
        threadB.start();
    }
}
