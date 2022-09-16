package product.bread;

import product.Product;

public abstract class Bread implements Product {
    private String name;
    private int price;
    private int weight;

    public Bread(String name, int price, int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public Bread setName(String name) {
        this.name = name;
        return this;
    }

    public Bread setPrice(int price) {
        this.price = price;
        return this;
    }

    public Bread setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("(%d г.)\t %s \t[%d руб.]",
                weight, name, price);
    }
}
