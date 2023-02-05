package com.cy.store.service;

import com.cy.store.entity.Order;

/** 处理订单和订单数据的业务层接口 */
public interface IOrderService {
    /*创建订单*/
    Order create(Integer aid, Integer[] cids, Integer uid, String username);
}
