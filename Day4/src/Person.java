import java.util.concurrent.Semaphore;
import java.util.Queue;
import java.util.LinkedList;
import java.lang.Thread;
import java.lang.Runnable;


public class Person implements Runnable {
    private final String name;
    private final boolean fromCityB;
    private final Bridge bridge;

    public Person(String name, boolean fromCityB, Bridge bridge) {
        this.name = name;
        this.fromCityB = fromCityB;
        this.bridge = bridge;
    }

    public String getName() {
        return name;
    }

    public boolean isFromCityB() {
        return fromCityB;
    }

    public void run() {
        try {
            bridge.crossBridge(this);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
