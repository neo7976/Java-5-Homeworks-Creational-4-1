package product;

import product.bread.Bread;
import product.bread.BreadType;

import java.util.List;

public interface Factory<T> {
    List<BreadType> getList();
    T getProductFromFactory(BreadType valueOf);
}
