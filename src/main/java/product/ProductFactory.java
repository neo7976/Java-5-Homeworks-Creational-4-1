package product;

import product.Product;
import product.ProductImp;
import product.ProductType;
import product.bread.BreadFactory;
import product.bread.BreadType;
import product.bread.Wheat;

public class ProductFactory extends ProductImp {
    BreadFactory breadFactory = new BreadFactory();

    public Product getProduct(ProductType productType) {

        Product product = null;
        switch (productType) {
            case BREAD -> {
                //получаем все наши значения хлеба
                System.out.println(breadFactory.getList());
                //Попробовать добавить сканер или динамический массив и вытаскивать через get(index + 1);
//                product = breadFactory.getBread(breadType);
                product = breadFactory.getBread(BreadType.BAGUETTE);
            }
            case FRUIT -> {

            }
        }
        return product;
    }

    public static void main(String[] args) {
        ProductFactory pf = new ProductFactory();
        System.out.println(pf.getProduct(ProductType.BREAD).toString());
        System.out.println(pf.getProduct(ProductType.BREAD).toString());
        System.out.println(pf.getProduct(ProductType.BREAD).toString());
    }
}
