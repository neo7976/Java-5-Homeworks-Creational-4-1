package product;

import java.util.Objects;

//убрали абстракт
public class ProductImp implements Product {
    private String name;
    private int price;
    private int weight;
    private int count;

    public ProductImp() {
    }

    public ProductImp(String name, int price, int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return String.format("(%d г.)\t %s\t\t\t[%d руб.] \t\t - %d шт.", weight, name, price, count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductImp productImp = (ProductImp) o;
        return price == productImp.price && weight == productImp.weight && name.equals(productImp.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, weight);
    }
}

