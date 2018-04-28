package main.juc.syn;

public class Test{
    private static int val = 0;
    public static void main(String[] args) {
        Object object = new Object();
        Thread threadA = new Thread(() -> {
            while(val < 10){
                if(val % 2 == 1){
                    synchronized (object){
                        System.out.println("A");
                        object.notifyAll();
                        val++;
                    }
                }
            }
        });

        Thread threadB = new Thread(() -> {
            while(val < 10){
                if(val % 2 == 0){
                    synchronized (object){
                        try{
                            val++;
                            object.wait();
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        System.out.println("B");
                    }
                }
            }
        });
        threadA.start();
        threadB.start();
    }
}
