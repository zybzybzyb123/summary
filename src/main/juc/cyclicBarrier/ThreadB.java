package main.juc.cyclicBarrier;

public class ThreadB implements Runnable {
    public volatile int val;
    public ThreadB(){}
    public ThreadB(int val){
        this.val = val;
    }
    public void run(){

    }
}