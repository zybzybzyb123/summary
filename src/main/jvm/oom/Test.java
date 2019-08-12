package main.jvm.oom;

import java.util.ArrayList;
import java.util.List;

class BigObject{
    private int[] mem = new int[10000];
}
public class Test {
    List<BigObject> list = new ArrayList<>();
    private void createObject(){
        int i = 0;
        try{
            for (i = 0; i < 30; i++){
                list.add(new BigObject());
            }
        } catch (Throwable e){
            e.printStackTrace();
        } finally {
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        Test test = new Test();
        //test.createObject();
        System.out.println("ok");
    }
}
