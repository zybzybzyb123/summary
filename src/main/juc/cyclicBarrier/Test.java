package juc.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String[] args) throws Exception{
        ExecutorService service = Executors.newFixedThreadPool(5);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        for(int j = 0; j < 2; j++){
            for(int i = 0; i < 5; i++){
                service.execute(new Player(j * 5 + i + 1, cyclicBarrier));
            }
            cyclicBarrier.reset();
            Thread.sleep(1000);
        }
    }
}
