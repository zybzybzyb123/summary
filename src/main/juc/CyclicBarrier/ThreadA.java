package main.juc.CyclicBarrier;


public class ThreadA implements Runnable {
    public volatile int val;
    public ThreadA(){}
    public ThreadA(int val){
        this.val = val;
    }
    public void run(){
        synchronized (this){
            try{
                System.out.println("A");
                wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
