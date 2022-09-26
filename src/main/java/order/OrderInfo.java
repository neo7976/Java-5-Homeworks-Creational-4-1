package order;

import product.Product;

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
    private final double countTotal;


    public OrderInfo(String id, Map<Product, Integer> mapOrder
//            , int countSum
            , double countTotal) {
        this.id = id;
        this.mapOrder = mapOrder;
//        this.countSum = countSum;
        this.countTotal = countTotal;
    }

    public OrderInfo(Map<Product, Integer> mapOrder
//            , int countSum
            , double countTotal) {
        this(null, mapOrder, countTotal);
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

    public void orderIsProcessed() {
        System.out.println("Вы оформили заказ:");

        //на этом шаге лучше сделать запись в файл
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

    public double getCountTotal() {
        return countTotal;
    }
}
