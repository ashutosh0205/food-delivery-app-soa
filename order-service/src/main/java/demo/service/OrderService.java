package demo.service;


import demo.model.Order;

public interface OrderService {
    Order createOrder(Order order);
    Order getOrder(Integer orderId);
}
