package main.patterns.proxy.dynamicProxy.cglibAOP;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxySubject implements MethodInterceptor {


    public void preRequest(){
        System.out.println("this is a preRequest");
    }

    public void postRequest(){
        System.out.println("this is a postRequest");
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] arg, MethodProxy proxy) throws Throwable {
        preRequest();
        Object object = proxy.invokeSuper(obj, arg);
        postRequest();
        return object;
    }

}
