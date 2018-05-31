package main.juc.syn;

import java.util.Arrays;
import java.util.Comparator;

public class PrintNums {
    private int state = 0; // 线程共有，判断所有的打印状态
    private Object object = new Object();
    private static final int cnt = 2;
    private static int limit;
    private  class MyThread extends Thread {

        int offset;
        int[] nums;

        public MyThread(int offset, int[] nums){
            this.offset = offset;
            this.nums = nums;
        }

        @Override
        public void run() {
            for(int i = 0; i < limit; i++) {
                synchronized (object) {
                    while (state % cnt != offset) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
//                    if(state >= limit) break;
                    System.out.println(state + " : " + nums[state / cnt]);
                    state++;
                    object.notifyAll(); // 调用notifyAll方法
                }
            }
            for(int i = limit; i < nums.length; i++){
                System.out.println(state++ + " : " + nums[i]);
            }
        }
    }

    public static void main(String[] args) {
        PrintNums printNums = new PrintNums();
        int[][] nums = new int[2][];
        nums[0] = new int[]{1,3};
        nums[1] = new int[]{2,4,6,8,10};
        limit = 2;
        for(int i = 0; i < cnt; i++){
            printNums.new MyThread(i, nums[i]).start();
        }
    }
}
