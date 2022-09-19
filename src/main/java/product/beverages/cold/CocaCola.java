package product.beverages.cold;

import product.Product;
import product.beverages.BeverageSize;
import product.beverages.Drink;

public class CocaCola extends Drink {

    public CocaCola(BeverageSize size) {
        super("Coca cola", size);
    }

//    public static void main(String[] args) {
//        Product drink = new CocaCola(BeverageSize.M);
//        System.out.println(drink);
//    }
}

