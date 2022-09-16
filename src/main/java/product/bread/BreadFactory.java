package product.bread;

public class BreadFactory {

    public Bread getBread(BreadType breadType) {
        Bread returnBread = null;
        switch (breadType) {
            case WHEAT -> returnBread = new Wheat();
            default -> throw new IllegalArgumentException("Ошибка ввода продукта" + breadType);
        }
        return returnBread;
    }
}
