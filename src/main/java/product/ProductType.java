package product;

public enum ProductType implements Type{
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
