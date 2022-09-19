package product;

import product.bread.BreadFactory;
import product.bread.BreadType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProductFactory extends ProductImp {
    private List<ProductType> productTypeList;
    private final List<Product> listBasket = new ArrayList<>();
    BreadFactory breadFactory = new BreadFactory();
    public Scanner scanner = new Scanner(System.in);

    public Product getProduct(ProductType productType) {
        Product product = null;

        switch (productType) {
            case BREAD -> {
                //получаем все наши значения хлеба и выбираем из списка
                printProductToBasket("Хлеб");
                System.out.println(breadFactory.getList());
                product = breadFactory.getBread(Enum.valueOf(BreadType.class, scanner.nextLine()));
                listBasket.add(product);
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
        for (Product product : listBasket) {
            System.out.println(product);
        }
    }
}
