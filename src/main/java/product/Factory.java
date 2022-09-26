package product;

import java.util.List;

public interface Factory<T, E> {
    List<E> getList();

    T getProductFromFactory(E valueOf);
}
