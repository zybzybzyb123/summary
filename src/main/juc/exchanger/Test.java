package juc.exchanger;

import java.util.concurrent.Exchanger;

public class Test {
    public static void main(String[] args) throws InterruptedException{
        Exchanger<String> exchanger = new Exchanger<>();
        for (int i = 0; i < 4; i++){
            new Thread(new MyThread(i, exchanger)).start();
            if (i > 2) Thread.sleep(1000);
        }
    }
}
