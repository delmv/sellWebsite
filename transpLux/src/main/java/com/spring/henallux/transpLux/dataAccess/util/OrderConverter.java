package com.spring.henallux.transpLux.dataAccess.util;

import com.spring.henallux.transpLux.dataAccess.entity.OrderEntity;
import com.spring.henallux.transpLux.model.Order;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {

    private Mapper mapper = new DozerBeanMapper();

    public OrderEntity orderModelToOrderEntity(Order order) {
        return mapper.map(order, OrderEntity.class);
    }

    public Order orderEntityToOrderModel(OrderEntity orderEntity) {
        return mapper.map(orderEntity, Order.class);
    }
    
}
