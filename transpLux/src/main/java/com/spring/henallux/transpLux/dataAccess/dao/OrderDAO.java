package com.spring.henallux.transpLux.dataAccess.dao;

import com.spring.henallux.transpLux.dataAccess.entity.LineItemEntity;
import com.spring.henallux.transpLux.dataAccess.entity.OrderEntity;
import com.spring.henallux.transpLux.dataAccess.repository.LineItemRepository;
import com.spring.henallux.transpLux.dataAccess.repository.OrderRepository;
import com.spring.henallux.transpLux.dataAccess.util.LineItemConverter;
import com.spring.henallux.transpLux.dataAccess.util.OrderConverter;
import com.spring.henallux.transpLux.model.LineItem;
import com.spring.henallux.transpLux.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDAO implements OrderAccessData {

    private OrderRepository orderRepository;
    private LineItemRepository lineItemRepository;
    private OrderConverter orderConverter;
    private LineItemConverter lineItemConverter;

    @Autowired
    public OrderDAO(OrderRepository orderRepository, LineItemRepository lineItemRepository, OrderConverter orderConverter, LineItemConverter lineItemConverter) {
        this.orderRepository = orderRepository;
        this.lineItemRepository = lineItemRepository;
        this.orderConverter = orderConverter;
        this.lineItemConverter = lineItemConverter;
    }

    @Override
    public void insertNewOrder(Order order, ArrayList<LineItem> items) {
        OrderEntity orderEntity = orderConverter.orderModelToOrderEntity(order);

        int orderId = orderRepository.save(orderEntity).getId();

        ArrayList<LineItemEntity> itemsEntity = lineItemConverter.lineItemArrayTolineItemEntityArray(items);

        itemsEntity.forEach(i -> i.setOrderId(orderId));

        itemsEntity.forEach(i -> lineItemRepository.save(i));
    }
}
