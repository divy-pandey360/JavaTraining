import java.lang.Thread;
import java.lang.Runnable;

public class Alternator {
    private Integer max;
    private Integer count=0;
    private boolean odd=false;

    public Alternator(Integer max){
        this.max=max;
    }

    public synchronized void printOdd(){
        while(count<=max){
            while(!odd){
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            if(count<=max){

                System.out.println("Odd::"+count);
                count++;
                odd=false;
                notifyAll();

            }
        }
    }


    public synchronized void printEven(){
        while(count<=max){
            while(odd){
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            if(count<=max){
                if(count%2==0){
                    System.out.println("Even::"+count);
                    count++;
                    odd=true;
                    notifyAll();
                }


            }
        }
    }


}

class Odd implements Runnable{

    private Alternator a;
    public Odd(Alternator a){
        this.a=a;
    }

    @Override
    public void run(){
        a.printOdd();
    }


}


class Even implements Runnable{

    private Alternator a;
    public Even(Alternator a){
        this.a=a;
    }

    @Override
    public void run(){
        a.printEven();
    }


}


class Main3{
    public static void main(String[] args){
        Alternator a=new Alternator(50);

        Thread t1=new Thread(new Odd(a));
        Thread t2=new Thread(new Even(a));

        t1.start();
        t2.start();

    }
}
