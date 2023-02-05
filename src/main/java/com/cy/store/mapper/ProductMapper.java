package com.cy.store.mapper;

import com.cy.store.entity.Product;

import java.util.List;

/* 处理商品数据的持久层接口 */
public interface ProductMapper {
    /* 查询热销商品的前四名*/
    List<Product> findHotList();
    /* 根据商品id查询商品详情*/
    Product findById(Integer id);
}