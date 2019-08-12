package main.juc.threadlocal;

public class MyThread extends Thread{

    @Override
    public void run(){
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        for (int i = 0; i < 9; i++){
//            ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
            threadLocal.set(i + 1);
        }
        System.out.println(threadLocal.get());
    }
}
