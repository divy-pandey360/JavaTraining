import java.lang.Thread;

class Printer1 {
    private Integer times = 100;
    private Integer count = 0;
    private boolean turn = true;
    private final Object lock=new Object();

    public void printPing() {
        synchronized(lock){
            while (count < times) {
                while (!turn) {
                    try {
                        lock.wait();
                        //Thread.sleep(100); // Sleep for a short duration
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("Ping"+count);
                count++;
                turn = false;
                lock.notify();
            }
        }


    }

    public void printPong() {
        synchronized(lock){
            while (count < times) {
                while (turn) {
                    try {
                        lock.wait();
                        //Thread.sleep(100); // Sleep for a short duration
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("Pong"+count);
                count++;
                turn = true;
                lock.notify();
            }
        }
    }
}

class PingPong extends Thread {
    Printer1 p;

    public PingPong(Printer1 p) {
        this.p = p;
    }

    @Override
    public void run() {
        p.printPing();
    }
}

class PongPing extends Thread {
    Printer1 p;

    public PongPing(Printer1 p) {
        this.p = p;
    }

    @Override
    public void run() {
        p.printPong();
    }
}

class Main5 {
    public static void main(String[] args) {
        Printer1 actualObj = new Printer1();
        PingPong p = new PingPong(actualObj);
        PongPing p2 = new PongPing(actualObj);

        Thread t1 = new Thread(p);
        Thread t2 = new Thread(p2);
        t1.start();
        t2.start();
    }
}
