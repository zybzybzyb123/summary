package juc.lock;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 基于lock condition的生产者消费者模型
 * @param <T>
 */
public class ProducerConsumer<T> {

    private Lock lock;

    private LinkedList<T> buffer;

    private int maxSize;

    private Condition fullCondition;

    private Condition emptyCondition;

    public ProducerConsumer(int maxSize) {
        this.maxSize = maxSize;
        lock = new ReentrantLock();
        buffer = new LinkedList<>();
        this.maxSize = maxSize;
        fullCondition = lock.newCondition();
        emptyCondition = lock.newCondition();
    }

    public void produce(T t) throws InterruptedException {

        lock.lock();
        try {
            while (maxSize == buffer.size()) {
                fullCondition.await();
                System.out.println("工厂产能达到极限，不能继续进行生产了,停工一段时间");
            }

            //队列没有满，可以生产
            buffer.add(t);

            System.out.println("哈哈，我生产了" + t + "，通知消费者进行消费...");
            //通知消费者线程进行消费
            emptyCondition.signalAll();

        } finally {
            lock.unlock();
        }
    }

    public void consume() throws InterruptedException {

        lock.lock();

        try {

            while (buffer.size() == 0) {
                System.out.println("工厂的产品已经消费完了，暂时不能剁手了");
                emptyCondition.await();
            }

            //开始消费
            T goods = buffer.poll();
            System.out.println("哈哈，我消费" + goods + "，通知工厂进行生产...");
            //通知生成者
            fullCondition.signalAll();

        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {

        ProducerConsumer producerConsumer = new ProducerConsumer(100);

        new Thread(() -> {

            for (int i = 0; i < 100; i++) {
                try {
                    producerConsumer.produce("笔记本电脑" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "produce").start();


        new Thread(() -> {

            while (true) {
                try {
                    producerConsumer.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "consume").start();

    }
}