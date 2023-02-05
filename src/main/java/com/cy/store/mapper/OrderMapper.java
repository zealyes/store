package com.cy.store.mapper;

import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;

/** 处理订单及订单商品数据的持久层接口 */
public interface OrderMapper {
    /* 插入订单数据*/
    Integer insertOrder(Order order);

    /*插入订单商品数据*/
    Integer insertOrderItem(OrderItem orderItem);
}
