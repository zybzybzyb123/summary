package juc.paterns.produceAndConsumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
    BlockingQueue<Integer> queue;
    public Producer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }
    public void run(){
        try{
            for (int i = 1; i <= 10; i++){
                Thread.sleep(100);
                queue.put(i);
                System.out.println("生产者: " + i);
            }
            queue.put(-1);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
