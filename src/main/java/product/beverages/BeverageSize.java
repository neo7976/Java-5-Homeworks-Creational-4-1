package product.beverages;

public enum BeverageSize {
    S("Маленький", 0.25d),
    M("Cредний", 0.33d),
    L("Большой", 0.5d);

    private String name;
    private double size;

    BeverageSize(String name, double size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public double getSize() {
        return size;
    }

    @Override
    public String toString() {
        return String.format("(%s - %.2fL)", name, size);
    }
}
