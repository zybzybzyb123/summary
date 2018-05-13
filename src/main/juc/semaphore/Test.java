package main.juc.semaphore;

import java.util.concurrent.Semaphore;

public class Test {
    private class MyThread implements Runnable{
        private Semaphore semaphore;

        public MyThread(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run(){
            try{
                semaphore.acquire();
                System.out.println("Thread " + Thread.currentThread().getName() + "执行了");
                System.out.println(semaphore.availablePermits());
                long j = 0;
                for(int i = 0; i < 100000; i++){
                    j += i;
                }
                System.out.println(j);
                semaphore.release();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        final int THREAD_COUNT = 100;
        Test test = new Test();
        for(int i = 0; i < THREAD_COUNT; i++){
            new Thread(test.new MyThread(semaphore), "Thread" + i).start();
        }
    }
}
