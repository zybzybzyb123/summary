package patterns.proxy.dynamicProxy.cglibAOP;

public class RealSubject implements Subject {

    @Override
    public void request(){
        System.out.println("this is a request");
    }
}
