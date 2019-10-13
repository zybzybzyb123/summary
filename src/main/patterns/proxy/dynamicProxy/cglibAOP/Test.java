package patterns.proxy.dynamicProxy.cglibAOP;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

public class Test {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new ProxySubject());
        Subject realSubject = (RealSubject) enhancer.create();
        realSubject.request();
    }

    private static <T, U extends MethodInterceptor> T generateProxy(T t, U u) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(t.getClass());
        enhancer.setCallback(u);
        return (T) enhancer.create();
    }
}
