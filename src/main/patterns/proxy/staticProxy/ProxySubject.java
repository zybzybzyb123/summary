package patterns.proxy.staticProxy;

public class ProxySubject implements Subject{
    private Subject subject;

    public  ProxySubject(Subject subject){
        this.subject = subject;
    }

    public void preRequest(){
        System.out.println("this is a preRequest");
    }

    public void postRequest(){
        System.out.println("this is a postRequest");
    }

    @Override
    public void request(){
        preRequest();
        subject.request();
        postRequest();
    }
}
