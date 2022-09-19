package product;

import product.Product;
import product.ProductImp;
import product.ProductType;
import product.bread.BreadFactory;
import product.bread.BreadType;
import product.bread.Wheat;

import java.util.Scanner;

public class ProductFactory extends ProductImp {
    BreadFactory breadFactory = new BreadFactory();
    Scanner scanner = new Scanner(System.in);

    public Product getProduct(ProductType productType) {

        Product product = null;

        switch (productType) {
            case BREAD -> {
                //получаем все наши значения хлеба и выбираем из списка
                System.out.println(breadFactory.getList());
                product = breadFactory.getBread(Enum.valueOf(BreadType.class, scanner.nextLine()));
            }
            case FRUIT -> {
            }
        }
        return product;
    }

    public static void main(String[] args) {
        ProductFactory pf = new ProductFactory();
        System.out.println(pf.getProduct(Enum.valueOf(ProductType.class, pf.scanner.nextLine())));

//        System.out.println(pf.getProduct(ProductType.BREAD).toString());
//        System.out.println(pf.getProduct(ProductType.BREAD).toString());
//        System.out.println(pf.getProduct(ProductType.BREAD).toString());
    }
}
