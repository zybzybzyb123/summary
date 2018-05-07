package main.patterns.proxy.dynamicProxy.cglibAOP;

import net.sf.cglib.proxy.Enhancer;

public class Test {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new ProxySubject());
        RealSubject realSubject = (RealSubject)enhancer.create();
        realSubject.request();
    }
}
