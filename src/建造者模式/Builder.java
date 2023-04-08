package 建造者模式;


public class Builder {
    public static void main(String[] args) {
        DefaultConcreteProductBuilder defaultConcreteProductBuilder = new DefaultConcreteProductBuilder();
        Director director = new Director(defaultConcreteProductBuilder);
        director.makeProduct("iPhone12", 101, "Apple", 2);
        System.out.println(defaultConcreteProductBuilder.build().toString());

    }
}

interface ProductBuilder{
    void buildProductName(String productName);
    void buildProductId(long id);
    void buildProductCompany(String company);
    void buildProductColor(int color);
    Product build();
}

class Product{
    private String productName;
    private long id;
    private String company;
    private int color;

    public Product(){

    }
    public Product(String productName, long id, String company, int color) {
        this.productName = productName;
        this.id = id;
        this.company = company;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", id=" + id +
                ", company='" + company + '\'' +
                ", color=" + color +
                '}';
    }
}

class DefaultConcreteProductBuilder implements ProductBuilder{
    private String productName;
    private long id;
    private String company;
    private int color;

    @Override
    public void buildProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public void buildProductId(long id) {
        this.id = id;
    }

    @Override
    public void buildProductCompany(String company) {
        this.company = company;
    }

    @Override
    public void buildProductColor(int color) {
        this.color = color;
    }

    @Override
    public Product build() {
        return new Product(productName, id, company, color);
    }
}

class Director{
    private ProductBuilder builder;

    public Director(DefaultConcreteProductBuilder defaultConcreteProductBuilder) {
        builder = defaultConcreteProductBuilder;
    }

    public Product makeProduct(String productName, long id, String company, int color){
        builder.buildProductName(productName);
        builder.buildProductId(id);
        builder.buildProductCompany(company);
        builder.buildProductColor(color);
        return builder.build();
    }
}