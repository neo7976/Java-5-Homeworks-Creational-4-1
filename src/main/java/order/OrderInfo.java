package order;

import com.google.gson.annotations.SerializedName;
import product.ProductImp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class OrderInfo {
    @SerializedName("Номер заказа")
    private String id;
    @SerializedName("Время заказа")
    private String data;
    @SerializedName("Список покупок")
    private List<ProductImp> listOrder;
    @SerializedName("Итоговая цена")
    private double priceTotal;


    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public OrderInfo(String id,String data, List<ProductImp> listOrder
            , double countTotal) {
        this.id = id;
        this.data = dtf.format(LocalDateTime.now());
        this.listOrder = listOrder;
        this.priceTotal = countTotal;
    }

    public OrderInfo(List<ProductImp> listOrder
            , double countTotal) {
        this(null, null,listOrder, countTotal);
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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
