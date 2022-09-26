package order;

import product.Product;
import product.ProductImp;

import java.util.Map;

//Сделать как класс записи в отдельный файл, чтобы можно было прочитать данные
public class OrderInfo {
    private String id;
    private Map<ProductImp, Integer> mapOrder;
    private double countTotal;


    public OrderInfo(String id, Map<ProductImp, Integer> mapOrder
            , double countTotal) {
        this.id = id;
        this.mapOrder = mapOrder;
        this.countTotal = countTotal;
    }

    public OrderInfo(Map<ProductImp, Integer> mapOrder
            , double countTotal) {
        this(null, mapOrder, countTotal);
    }

    public OrderInfo() {
    }

    public void setMapOrder(Map<ProductImp, Integer> mapOrder) {
        this.mapOrder = mapOrder;
    }

    public Map<ProductImp, Integer> getMapOrder() {
        return mapOrder;
    }

    public String getId() {
        return id;
    }

    public void orderIsProcessed() {
        System.out.println("Вы оформили заказ:");

        //на этом шаге лучше сделать запись в файл
    }
    public double getCountTotal() {
        return countTotal;
    }

    public void setId(String id) {
        this.id = id;
    }
}
