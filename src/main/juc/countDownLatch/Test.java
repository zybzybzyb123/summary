package juc.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class Test {
    private class MyThread extends Thread{
        private int offset;
        private CountDownLatch count;
        public MyThread(int offset, CountDownLatch count){
            this.offset = offset;
            this.count = count;
        }
        @Override
        public void run(){
            System.out.println((char)('A' + offset));
            count.countDown();
        }
    }
    public static void main(String[] args) throws Exception{
        Test test = new Test();
        CountDownLatch count = new CountDownLatch(3);
        for(int i = 0; i < 3; i++){
            test.new MyThread(i, count).start();
        }
        //主线程阻塞，等待调用countDown
        count.await();
        System.out.println("main方法执行了");
    }
}
