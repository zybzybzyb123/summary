package main.patterns.abstractFactory;

class ContainerProductA extends ContainerProduct{
    public ContainerProductA(){
        System.out.println("this is a ContainerProductA");
    }
}

class ContainerProductB extends ContainerProduct{
    public ContainerProductB(){
        System.out.println("this is a ContainerProductB");
    }
}

class MouldProductA extends MouldProduct{
    public MouldProductA(){
        System.out.println("this is a MouldProductA");
    }
}

class MouldProductB extends MouldProduct{
    public MouldProductB(){
        System.out.println("this is a MouldProductB");
    }
}

abstract class MouldProduct extends Product{
    public MouldProduct(){
        System.out.println("this is a MouldProduct");
    }
}

abstract class ContainerProduct extends Product{
    public ContainerProduct(){
        System.out.println("this is a ContainerProduct");
    }
}

public abstract class Product {
    public Product(){
        System.out.println("this is a product");
    }
}
