package product;

public enum ProductType {
    BREAD("Хлеб"),
    FRUIT("Фрукт");

    private String name;

    ProductType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
