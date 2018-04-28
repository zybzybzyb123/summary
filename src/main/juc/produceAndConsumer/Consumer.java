package main.juc.produceAndConsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    BlockingQueue<Integer> queue;
    public Consumer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }
    public void run(){
        int val;
        try{
            while((val = queue.take()) != -1){
                Thread.sleep(100);
                System.out.println("消费者: " + val + " " + val * val);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
