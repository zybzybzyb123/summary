package main.juc.lock;

public class Test {
    public static void main(String[] args) {
        int val = 5;
        ThreadA threadA = new ThreadA(val);
        ThreadB threadB = new ThreadB(val);
        new Thread(threadA).start();
        new Thread(threadB).start();
    }
}
