package product.beverages;

import product.Product;

public abstract class Drink implements Product {
    BeverageSize size;
    private String name;
    private double price;

    public Drink(String name, BeverageSize size) {
        super();
        this.name = name;
        this.size = size;
        this.price = newPrice(size);
        if (this.size == null)
            this.size = BeverageSize.M;
    }

    public BeverageSize getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double newPrice(BeverageSize size) {
        if (getSize() != null) {
            switch (getSize()) {
                case S -> price = 80d;
                case M -> price = 120d;
                case L -> price = 150d;
            }
        } else
            price = 0;
        return price;
    }

    public String toString() {
        return name + size + " [" + price + " руб.]";
    }
}
