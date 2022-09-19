package product.beverages.cold;

import product.Product;
import product.beverages.BeverageSize;
import product.beverages.Drink;

public class DrinkFactory {
    public Drink getDrink(DrinkType type) {
        Drink drink = null;
        switch (type) {
            case COLA -> {
                //нужно добавить возможность выбора размера напитка
                BeverageSize m = BeverageSize.M;
                drink = new CocaCola(m);
            }
            case FANTA -> {
                BeverageSize l = BeverageSize.L;
                drink = new Fanta(l);
            }
            case PEPSI -> {
                BeverageSize s = BeverageSize.S;
                drink = new Pepsi(s);
            }
            case SPRITE -> {
                BeverageSize m = BeverageSize.M;
                drink = new Sprite(m);
            }
            default -> throw new IllegalArgumentException("Такого напитка нет");
        }
        return drink;
    }


}
