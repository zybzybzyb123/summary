package main.patterns.proxy.dynamicProxy.jdkAOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        InvocationHandler handler = new ProxySubject(subject);
        subject = (Subject) Proxy.newProxyInstance(subject.getClass().getClassLoader(),
                                                    subject.getClass().getInterfaces(),
                                                    handler);
        subject.request();
    }
}
