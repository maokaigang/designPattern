package 建造者模式;

public class BuilderV2 {
    public static void main(String[] args) {
        ProductV2 product = new ProductV2
                .Builder()
                .productName("iPhone12")
                .id(102).company("Apple")
                .color(Color.BLUE)
                .build();
        System.out.println(product);
    }


}

enum Color {
    REA,
    Green,
    WHITE,
    BLUE,
    GRAY,
    BLACK
}


class ProductV2{
    private final String productName;
    private final long id;
    private final String company;
    private final Color color;

    static class Builder{
        private String productName;
        private long id;
        private String company;
        private Color color;

        public Builder productName(String productName){
            this.productName = productName;
            return this;
        }

        public Builder id(long id){
            this.id = id;
            return this;
        }

        public Builder company(String company){
            this.company = company;
            return this;
        }

        public Builder color(Color color){
            this.color = color;
            return this;
        }

        ProductV2 build(){
            return new ProductV2(productName, id, company, color);
        }
    }

    public ProductV2(String productName, long id, String company, Color color) {
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