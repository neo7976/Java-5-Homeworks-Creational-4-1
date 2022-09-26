package product.bread;
import product.Product;
import java.util.Objects;

public abstract class Bread implements Product {
    private String name;
    private int price;
    private int weight;

    public Bread(String name, int price, int weight) {
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

    @Override
    public String toString() {
        return String.format("(%d г.)\t %s \t\t[%d руб.]",
                weight, name, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bread bread = (Bread) o;
        return price == bread.price && weight == bread.weight && name.equals(bread.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, weight);
    }
}
