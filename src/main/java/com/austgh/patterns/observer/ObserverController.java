package com.austgh.patterns.observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by think on 2021/1/15.
 */
@RestController
@RequestMapping("/order")
public class ObserverController {
    @Autowired
    OrderService orderService;
    @RequestMapping("/saveOrder")
    public String saveOrder(){
        return orderService.saveOrder();
    }
}
