package patterns.factory;

interface Fruit {
    void say();
}
class Apple implements Fruit {
    @Override
    public void say(){
        System.out.println("this is a apple");
    }
}

class Orange implements Fruit {
    @Override
    public void say(){
        System.out.println("this is a orange");
    }
}

class Factory{
    public Fruit getFruit(String fruit){
        if(fruit.equals("apple")){
            return new Apple();
        } else if(fruit.equals("orange")){
            return new Orange();
        } else{
            return null;
        }
    }
}
public class Test {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Fruit fruit1 = factory.getFruit("apple");
        fruit1.say();
        Fruit fruit2 = factory.getFruit("orange");
        fruit2.say();
    }
}
