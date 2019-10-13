package patterns.proxy.dynamicProxy.cglibAOP;

public class RealSubject1 implements Subject {

    @Override
    public void request(){
        System.out.println("this is second request");
    }
}
