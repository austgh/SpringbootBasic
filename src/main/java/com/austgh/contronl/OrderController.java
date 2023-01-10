package com.austgh.contronl;

import com.austgh.service.OrderService;
import org.springframework.stereotype.Component;

/**
 * Created by think on 2021/1/15.
 */
@Component
public class OrderController {

    OrderService orderService;

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
