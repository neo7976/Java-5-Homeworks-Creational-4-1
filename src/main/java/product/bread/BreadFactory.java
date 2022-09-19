package product.bread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BreadFactory {
    private List<BreadType> list;
    private int wheatCount = 0;
    private int ciabattaCount = 0;
    private int baguetteCount = 0;


    public Bread getBread(BreadType breadType) {
        Bread returnBread = null;

        switch (breadType) {
            case WHEAT -> {
                returnBread = new Wheat(80, 500);
                wheatCount++;
            }
            case CIABATTA -> {
                returnBread = new Ciabatta(150, 500);
                ciabattaCount++;
            }
            case BAGUETTE -> {
                returnBread = new Baguette(120, 500);
                baguetteCount++;
            }
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
