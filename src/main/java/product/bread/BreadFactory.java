package product.bread;

import product.Factory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BreadFactory implements Factory<Bread, BreadType> {
    private List<BreadType> list;

    public Bread getProductFromFactory(BreadType breadType) {
        Bread returnBread = null;

        switch (breadType) {
            case WHEAT -> returnBread = new Wheat(80, 500);
            case CIABATTA -> returnBread = new Ciabatta(150, 500);
            case BAGUETTE -> returnBread = new Baguette(120, 500);
            default -> throw new IllegalArgumentException("Ошибка ввода продукта" + breadType);
        }
        return returnBread;
    }

    public List<BreadType> getList() {
        if (this.list == null) {
            list = new ArrayList<>();
            list.addAll(Arrays.asList(BreadType.values()));
        }
        return list;
    }
}
