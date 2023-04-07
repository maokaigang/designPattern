package 工厂模式;

public class FactoryMethod {
    public static void main(String[] args) {
        Application application = new ConcreteProductProductA();
        Product product = application.getObject();
        product.method1();
    }
}

interface Product{
    public void method1();
}

class ProductA implements Product{
    public void method1(){
        System.out.println("ProductA.method1 exec");
    }
}

class ProductB implements Product{
    public void method1(){
        System.out.println("ProductB.method1 exec");
    }
}

abstract class Application{
    abstract Product createProduct();

    Product getObject(){
        Product product = createProduct();
        return product;
    }
}
/*
    开闭原则，对扩展开放，对修改封闭
 */
class ConcreteProductProductA extends Application{
    @Override
    Product createProduct() {
        return new ProductA();
    }
}

class ConcreteProductProductB extends Application{
    @Override
    Product createProduct() {
        return new ProductB();
    }
}

/*
    简单工厂，根据类型参数创建不同对象
    Product product = SimpleFactory.createProduct("xxx");
 */
class SimpleFactory{
    public static Product createProduct(String type){
        if(type.equals("0")){
            return new ProductA();
        }else if(type.equals("1")){
            return new ProductB();
        }else {
            return null;
        }
    }
}