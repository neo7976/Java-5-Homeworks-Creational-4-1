package repository;

import order.OrderInfo;

public interface OrderInfoRepository {

    OrderInfo getById(String id);

    String add(OrderInfo orderInfo);

    OrderInfo remove(String id);

    OrderInfo update(String id);

}
