import product.Product;
import product.ProductImp;
import product.ProductType;

public class ProductFactory extends ProductImp {

    public Product getProduct(ProductType productType) {

        Product product = null;
        switch (productType) {
            case BREAD -> product = null;
        }
        return product;
    }
}
