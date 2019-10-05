package base.abstractClass;

import java.lang.reflect.Method;

/**
 *
 */
public class Test extends Person{
    public static void main(String[] args) throws Exception{
        Class clazz = Class.forName("base.abstractClass.Person");
        Method method = clazz.getDeclaredMethod("say");
        method.setAccessible(true);
        System.out.println(method.getModifiers());
    }
}
