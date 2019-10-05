package patterns.proxy.staticProxy;

public class Test {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        Subject subject = new ProxySubject(realSubject);
        subject.request();
    }
}
