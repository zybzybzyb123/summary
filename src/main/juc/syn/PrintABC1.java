package juc.syn;

/**
 *
 */

public class PrintABC1 {
    private volatile static int val = 0;
    public static void main(String[] args) {
        Object object = new Object();
        int n = 9;
        new Thread(() -> {
            while (val < n){
                if (val % 3 == 0){
                    synchronized (object){
                        val++;
                        System.out.println("A");
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (val < n){
                if (val % 3 == 1){
                    synchronized (object){
                        val++;
                        System.out.println("B");
                    }
                }
            }
        }).start();
        new Thread(() -> {
            while (val < n){
                if (val % 3 == 2){
                    synchronized (object){
                        val++;
                        System.out.println("C");
                    }
                }
            }
        }).start();
    }
}
