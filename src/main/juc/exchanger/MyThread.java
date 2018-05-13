package main.juc.exchanger;

import org.omg.CORBA.INITIALIZE;

import java.util.concurrent.Exchanger;

public class MyThread implements Runnable{
    private int offset;
    private Exchanger<String> exchanger;

    public MyThread(int offset, Exchanger<String> exchanger) {
        this.offset = offset;
        this.exchanger = exchanger;
    }

    @Override
    public void run(){
        try{
            String str = exchanger.exchange(String.valueOf((char)('A' + offset)));
            System.out.println(offset + str);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
