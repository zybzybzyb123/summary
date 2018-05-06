package main.juc.syn;

public class PrintABC2 {
    private int state = 0; // 线程共有，判断所有的打印状态
    private Object object = new Object();
    private  class MyThread extends Thread {
        int offset; // 0：打印A；1：打印B；2：打印C

        public MyThread(int offset) {
            this.offset = offset;
        }
        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                synchronized (object) {
                    while (state % 3 != offset) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println((char) ('A' + offset)); // 执行到这里，表明满足条件，打印
                    state++;
                    object.notifyAll(); // 调用notifyAll方法
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintABC2 printABC2 = new PrintABC2();
        for(int i = 0; i < 3; i++){
            printABC2.new MyThread(i).start();
        }
    }
}
