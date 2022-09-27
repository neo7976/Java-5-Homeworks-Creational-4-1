package product.beverages.cold;

import product.Product;
import product.beverages.BeverageSize;

public class Sprite extends ColdDrinks {
    public Sprite(BeverageSize size) {
        super("Sprite", size);
    }

    @Override
    public double newPrice(BeverageSize size) {
        if (getSize() != null) {
            switch (getSize()) {
                case S -> setPrice(90d);
                case M -> setPrice(130d);
                case L -> setPrice(160d);
            }
        } else
            setPrice(0);
        return getPrice();
    }

}
