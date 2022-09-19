package order;

import product.Product;

import java.util.HashMap;
import java.util.Map;

//Сделать как класс записи в отдельный файл, чтобы можно было прочитать данные
public class Order {
    private String id;
    private String name;
    private int price;
    private int weight;
    private int count;
    private int countSum;
    private int countTotal;

    private Map<Product, Integer> mapOrder;

    public void setMapOrder(Map<Product, Integer> mapOrder) {
        this.mapOrder = mapOrder;
    }

    public Map<Product, Integer> getMapOrder() {
        return mapOrder;
    }

    public String getId() {
        return id;
    }

    public void setName() {
        this.id = id;
    }

    public void orderIsProcessed() {
        System.out.println("Вы оформили заказ:");

        //на этом шаге лучше сделать запись в файл
        mapOrder = new HashMap<>();
    }
}
