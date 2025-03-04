import java.lang.Thread;
import java.lang.Runnable;

public class BridgeManagement {
    public static void main(String[] args) {
        Bridge bridge = new Bridge();

        Thread person1 = new Thread(new Person("Person1",true, bridge));
        Thread person2 = new Thread(new Person("Person2", true, bridge));
        Thread person3 = new Thread(new Person("Person3", false, bridge));
        Thread person4 = new Thread(new Person("Person4", false, bridge));
        Thread person5= new Thread(new Person("Person5",true, bridge));
        Thread person6 = new Thread(new Person("Person6", true, bridge));
        Thread person7 = new Thread(new Person("Person7", false, bridge));
        Thread person8 = new Thread(new Person("Person8", false, bridge));
        Thread person9 = new Thread(new Person("Person9",true, bridge));
        Thread person10 = new Thread(new Person("Person10", true, bridge));
        Thread person11 = new Thread(new Person("Person11", false, bridge));
        Thread person12 = new Thread(new Person("Person12", false, bridge));

        person1.start();
        person2.start();
        person3.start();
        person4.start();
        person5.start();
        person6.start();
        person7.start();
        person8.start();
        person9.start();
        person10.start();
        person11.start();
        person12.start();

    }
}
