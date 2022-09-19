package product;

import product.bread.Bread;
import product.bread.BreadFactory;
import product.bread.BreadType;

import java.util.*;

public class ProductFactory {
    private final Map<Product, Integer> mapBasket = new HashMap<>();
    private List<ProductType> productTypeList;
    Factory<Bread, BreadType> breadFactory = new BreadFactory();
    public Scanner scanner = new Scanner(System.in);

    public Product getProduct(ProductType productType) {
        Product product = null;

        switch (productType) {
            case BREAD -> {
                //получаем все наши значения хлеба и выбираем из списка
                productCreate(breadFactory, ProductType.BREAD);
                product = breadFactory.getProductFromFactory(Enum.valueOf(BreadType.class,
                        scanner.nextLine().toUpperCase()));
                System.out.println("Какое количество данного продукта добавить в корзину?");
                countProduct(product,
                        Integer.parseInt(scanner.nextLine()));
            }
            case FRUIT -> {
            }
        }
        return product;
    }

    private void productCreate(Factory factory, Type type) {
        printProductToBasket(type.getName());
        System.out.println(factory.getList());
    }

    public void getList() {
        if (this.productTypeList == null) {
            productTypeList = new ArrayList<>();
            productTypeList.addAll(Arrays.asList(ProductType.values()));
        }
        System.out.println(productTypeList);
    }

    public void printProductToBasket(String name) {
        System.out.printf("Какой \"%s\" добавить в корзину?\n", name);
    }

    public void getListBasket() {
        System.out.println("В вашей корзине имеются следующие продукты: ");
        for (Map.Entry<Product, Integer> entry : mapBasket.entrySet()) {
            System.out.println(entry.getKey() + "\t\t-\t\t" + entry.getValue() + " шт.");
        }
    }

    public void countProduct(Product product, int value) {
        if (value != 0) {
            if (mapBasket.containsKey(product)) {
                int count = mapBasket.get(product);
                mapBasket.put(product, count + value);
            } else
                mapBasket.put(product, value);
        }
    }

}
