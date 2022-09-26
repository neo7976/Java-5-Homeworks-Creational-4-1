package order;

import product.Product;

import java.util.HashMap;
import java.util.Map;

//Сделать как класс записи в отдельный файл, чтобы можно было прочитать данные
public class OrderInfo {
    private String id;
    private Map<Product, Integer> mapOrder;
    private String name;
    private int price;
    private int weight;
    private int count;
    private int countSum;
    private int countTotal;




    public OrderInfo(String id, Map<Product, Integer> mapOrder, int countSum, int countTotal) {
        this.id = id;
        this.mapOrder = mapOrder;
        this.countSum = countSum;
        this.countTotal = countTotal;
    }

    public OrderInfo( Map<Product, Integer> mapOrder, int countSum, int countTotal) {
        this(null, mapOrder, countSum, countTotal);
    }

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

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public int getCount() {
        return count;
    }

    public int getCountSum() {
        return countSum;
    }

    public int getCountTotal() {
        return countTotal;
    }
}
