package juc.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Player implements Runnable{
    private int id;
    private CyclicBarrier cyclicBarrier;

    public Player(int id, CyclicBarrier cyclicBarrier) {
        this.id = id;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run(){
        try{
            System.out.format("玩家 %d 已准备,等待其他玩家准备\n", id);
            cyclicBarrier.await();
            System.out.format("玩家 %d 已加入游戏\n", id);
        } catch (InterruptedException | BrokenBarrierException e){
            e.printStackTrace();
        }
    }
}
