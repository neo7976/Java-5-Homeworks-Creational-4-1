package repository;

import order.OrderInfo;

import java.io.IOException;

public interface OrderInfoRepository {

    OrderInfo getById(String id) throws IOException;

    String add(OrderInfo orderInfo) throws IOException;

    OrderInfo remove(String id);

    void returnOrder(String id) throws IOException;

}
