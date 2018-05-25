package main.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyThread implements Runnable {
    private Lock lock;
    private Condition condition;
    private int offset;
    //state必须是公有变量
    private static int state = 0;

    public MyThread(Lock lock, Condition condition, int offset) {
        this.lock = lock;
        this.condition = condition;
        this.offset = offset;
    }

    public void run(){
        for(int i = 0; i < 3; i++){
            lock.lock();
            try{
                while (state % 3 != offset){
                    condition.await();
                }
                condition.signalAll();
                state++;
                System.out.println((char)('A' + offset));
            } catch (InterruptedException e){
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
