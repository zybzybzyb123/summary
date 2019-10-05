package juc.threadlocal;

public class Test {
    public static void main(String[] args) throws Exception{
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(1000);
        System.out.println("main");
    }
}
