package juc.cas;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException{
        ClassLoader classLoader = null;
        System.out.println(classLoader);
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        System.out.println(unsafe);
    }
}
