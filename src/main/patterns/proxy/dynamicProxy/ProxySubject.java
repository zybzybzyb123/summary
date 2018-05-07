package main.patterns.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxySubject implements InvocationHandler {

    private Object proxySubject;

    public ProxySubject(Object proxySubject) {
        this.proxySubject = proxySubject;
    }


    public void preRequest(){
        System.out.println("this is a preRequest");
    }

    public void postRequest(){
        System.out.println("this is a postRequest");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        preRequest();
        method.invoke(proxySubject, args);
        postRequest();
        return null;
    }
}
