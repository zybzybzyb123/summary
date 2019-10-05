package juc.syn;

public class Test {
    private int cnt = 10;
    private final Object lock = new Object();
    private int val = 1;
    private int threadNums = 3;
    private  class Print extends Thread{
        private final int offset;
        public Print(int offset){
            this.offset = offset;
        }
        public void run(){
            for (int i = 0; i < cnt; i++) {
                synchronized (lock){
                    while (val % threadNums != offset){
                        try{
                            lock.wait();
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    System.out.println(val++);
                    lock.notifyAll();
                }
            }
        }
    }
    public static void main(String[] args) {
        Test test = new Test();
        for (int i = 1; i <= test.threadNums; i++){
            test.new Print(i % test.threadNums).start();
        }
    }
}
