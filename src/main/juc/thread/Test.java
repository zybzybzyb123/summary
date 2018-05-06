package main.juc.thread;


public class Test {
    private static int THREADS_COUNT = 10;
    private volatile static int cnt = 0;
    public static void main(String[] args) throws Exception{
    Thread[] threads = new Thread[THREADS_COUNT];
        for(int i = 0; i < THREADS_COUNT; i++){
            threads[i] = new Thread(() -> {
                for(int j = 0; j < 10000; j++){
                    cnt++;
                }
            });
            threads[i].start();
        }
//        while(Thread.activeCount() > 1){
//            Thread.yield();
//        }
        for(int i = 0; i < THREADS_COUNT; i++){
            while(threads[i].isAlive());
        }
//        Thread.sleep(1000);
        System.out.println(cnt);
    }
}
