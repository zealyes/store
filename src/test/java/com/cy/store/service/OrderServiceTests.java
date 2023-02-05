package com.cy.store.service;

import com.cy.store.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderServiceTests {
    @Autowired
    private IOrderService orderService;

    @Test
    public void create() {
        Integer[] cids = {6};
        Order order = orderService.create(5,cids,6,"王武");
        System.out.println(order);
    }
}
