package main.juc.lock;

public class ThreadB implements Runnable {
    public volatile int val;
    public ThreadB(){}
    public ThreadB(int val){
        this.val = val;
    }
    public void run(){
        while(val > 0)
        synchronized (this){
            System.out.println("B");
            notifyAll();
        }
    }
}
