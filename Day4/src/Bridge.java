import java.util.concurrent.Semaphore;
import java.util.Queue;
import java.util.LinkedList;
import java.lang.Thread;
import java.lang.Runnable;

public class Bridge {
    private boolean tokenInCityB = true;


    public synchronized void crossBridge(Person person) throws InterruptedException {

            if (person.isFromCityB() && tokenInCityB) {
                tokenInCityB = false;
            } else if (!person.isFromCityB() && !tokenInCityB) {
                tokenInCityB = true;
          } // else {
//                wait();
//            }

        System.out.println(person.getName() + " is crossing the bridge from " + (person.isFromCityB() ? "City B to City A" : "City A to City B"));
        Thread.sleep(1000);
        System.out.println(person.getName() + " has crossed the bridge");

        notifyAll();
    }
}
