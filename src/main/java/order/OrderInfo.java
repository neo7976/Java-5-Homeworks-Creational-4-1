package order;

import product.ProductImp;

import java.util.List;

public class OrderInfo {
    private String id;
    private List<ProductImp> listOrder;
    private double priceTotal;


    public OrderInfo(String id, List<ProductImp> listOrder
            , double countTotal) {
        this.id = id;
        this.listOrder = listOrder;
        this.priceTotal = countTotal;
    }

    public OrderInfo(List<ProductImp> listOrder
            , double countTotal) {
        this(null, listOrder, countTotal);
    }

    public OrderInfo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ProductImp> getListOrder() {
        return listOrder;
    }

    public void setListOrder(List<ProductImp> listOrder) {
        this.listOrder = listOrder;
    }

    public double getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(double priceTotal) {
        this.priceTotal = priceTotal;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "id='" + id + '\'' +
                ", listOrder=" + listOrder +
                ", priceTotal=" + priceTotal +
                '}';
    }
}
