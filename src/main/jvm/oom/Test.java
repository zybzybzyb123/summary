package jvm.oom;

import java.util.ArrayList;
import java.util.List;

class BigObject{
    private int[] mem = new int[10000];
}
public class Test {
    List<BigObject> list = new ArrayList<>();
    private void createObject(){
        try{
            for (int i = 0; i < 300000; i++){
                list.add(new BigObject());
            }
        } catch (Throwable e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Test test = new Test();
        test.createObject();
        System.out.println("ok");
    }
}
