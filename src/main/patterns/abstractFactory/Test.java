package patterns.abstractFactory;

public class Test {
    public static void main(String[] args) {
        FactoryA factoryA = new FactoryA();
        FactoryB factoryB = new FactoryB();
        //A厂当地客户需要容器产品A
        factoryA.ManufactureContainer();
        //A厂当地客户需要模具产品A
        factoryA.ManufactureMould();

        //B厂当地客户需要容器产品B
        factoryB.ManufactureContainer();
        //B厂当地客户需要模具产品B
        factoryB.ManufactureMould();
    }
}
