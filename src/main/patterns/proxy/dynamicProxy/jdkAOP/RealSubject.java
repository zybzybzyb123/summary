package patterns.proxy.dynamicProxy.jdkAOP;

public class RealSubject implements Subject{

    @Override
    public void request(){
        System.out.println("this is a request");
    }
}
