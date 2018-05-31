package main.juc.syn;

/**
 * 两个线程轮流打印数组的值
 */

public class PrintNums {
    // 线程共有，判断所有的打印状态
    private int state = 0;
    //公共对象锁
    private Object object = new Object();
    //线程数
    private static final int cnt = 2;
    //limit保存数组长度的小值
    private static int limit;
    private  class MyThread extends Thread {
        //偏移值，可以看作数组指针
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
                    System.out.println(state + " : " + nums[state / cnt]);
                    state++;
                    //执行完函数再唤醒
                    object.notifyAll();
                }
            }
            //单独处理数组长度不一样的情况，这种情况下变为单线程
            for(int i = limit; i < nums.length; i++){
                System.out.println(state++ + " : " + nums[i]);
            }
        }
    }

    public static void main(String[] args) {
        PrintNums printNums = new PrintNums();
        int[][] nums = new int[2][];
        nums[0] = new int[]{1,3,5,7,9,11,13,15};
        nums[1] = new int[]{2,4,6,8,10};
        limit = Math.min(nums[0].length, nums[1].length);
        for(int i = 0; i < cnt; i++){
            printNums.new MyThread(i, nums[i]).start();
        }
    }
}
