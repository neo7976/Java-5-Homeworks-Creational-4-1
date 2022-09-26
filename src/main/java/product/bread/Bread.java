package product.bread;

import product.Product;
import product.ProductImp;

import java.util.Objects;

public abstract class Bread extends ProductImp {

    public Bread(String name, int price, int weight) {
        super(name, price, weight);

    }
}
