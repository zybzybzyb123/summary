package patterns.singleton;

public class Singleton {
    private Singleton(){

    }
    public static Singleton getInstance(){
        return InnerTest.singleton;
    }
    private static class InnerTest{
        private static final Singleton singleton = new Singleton();
    }
}
