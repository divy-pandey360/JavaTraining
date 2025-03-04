import java.lang.Thread;

public class MyCriticalSection {
    private Integer max=100;
    private Integer cnt=0;
    private boolean pong=true;



    public synchronized void printPong(){
        System.out.println("Pong thread status::"+ Thread.currentThread().getState());
        while(cnt<max){
            while(!pong){
                try{
                    wait();
                } catch (InterruptedException e ) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Pong"+cnt);
            cnt++;
            pong=false;
            notify();
            System.out.println("Pong thread status after codeBlock::"+ Thread.currentThread().getState());
        }
    }

    public synchronized void printPing(){
        System.out.println("Pong thread status::"+ Thread.currentThread().getState());
        while(cnt<max){
            while(pong){
                try{
                    wait();
                } catch (InterruptedException e ) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Ping"+cnt);
            cnt++;
            pong=true;
            notify();
            System.out.println("Pong thread status after codeBlock::"+ Thread.currentThread().getState());
        }
    }
}

class Ping1 extends Thread{
    private MyCriticalSection cs=new MyCriticalSection();
    public Ping1(MyCriticalSection cs){
        this.cs=cs;
    }

    @Override
    public void run(){
        cs.printPing();
    }
}

class Pong1 extends Thread{
    private MyCriticalSection cs=new MyCriticalSection();
    public Pong1(MyCriticalSection cs){
        this.cs=cs;
    }

    @Override
    public void run(){
        cs.printPong();
    }
}

class Main7 extends Thread{
    public static void main(String[] args){
        MyCriticalSection cs=new MyCriticalSection();

        Ping1 ping=new Ping1(cs);
        Pong1 pong=new Pong1(cs);

        Thread t1=new Thread(ping);
        Thread t2=new Thread(pong);
        System.out.println("Initial State of ping thread::"+t1.getState());
        System.out.println("Initial State of pong thread::"+t2.getState());


        t1.start();
        t2.start();
        System.out.println("Final State of ping thread::"+t1.getState());
        System.out.println("Final State of pong thread::"+t2.getState());

    }
}
