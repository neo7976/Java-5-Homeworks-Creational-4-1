package product.fruit;

import product.Factory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FruitFactory implements Factory<Fruit, FruitType> {
    private List<FruitType> list;

    public Fruit getProductFromFactory(FruitType fruitType) {
        Fruit returnFruit = null;

        switch (fruitType) {
            case BANANA -> returnFruit = new Banana(100, 1000);
            case ORANGE -> returnFruit = new Orange(80, 1000);
            case GRAPEFRUIT -> returnFruit = new Grapefruit(150, 1000);
            default -> throw new IllegalArgumentException("Ошибка ввода продукта" + fruitType);
        }
        return returnFruit;
    }

    public List<FruitType> getList() {
        if (this.list == null) {
            list = new ArrayList<>();
            list.addAll(Arrays.asList(FruitType.values()));
        }
        return list;
    }

}
