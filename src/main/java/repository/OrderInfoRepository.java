package repository;

import order.OrderInfo;

import java.io.IOException;

public interface OrderInfoRepository {

    OrderInfo getById(String id);

    String add(OrderInfo orderInfo) throws IOException;

    OrderInfo remove(String id);

    OrderInfo update(String id);

}
