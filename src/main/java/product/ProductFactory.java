package product;

import jdk.swing.interop.SwingInterOpUtils;
import product.bread.Bread;
import product.bread.BreadFactory;
import product.bread.BreadType;

import java.util.*;

public class ProductFactory extends ProductImp {
    private final Map<Product, Integer> mapBasket = new HashMap<>();
    private List<ProductType> productTypeList;
    BreadFactory breadFactory = new BreadFactory();
    public Scanner scanner = new Scanner(System.in);

    public Product getProduct(ProductType productType) {
        Product product = null;

        switch (productType) {
            case BREAD -> {
                //получаем все наши значения хлеба и выбираем из списка
                //TODO попробовать создать интерфейс или абстрактный класс,
                // от которого будут наследоваться остальные фабрики,
                // чтобы создать один единый метод
                printProductToBasket("Хлеб");
                System.out.println(breadFactory.getList());
                Bread bread = breadFactory.getBread(Enum.valueOf(BreadType.class, scanner.nextLine()));
                System.out.println("Какое количество данного продукта добавить в корзину?");
                countProduct(bread,
                        Integer.parseInt(scanner.nextLine()));
            }
            case FRUIT -> {
            }
        }
        return product;
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
