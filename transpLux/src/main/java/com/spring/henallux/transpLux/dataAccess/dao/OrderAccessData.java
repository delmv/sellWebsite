package com.spring.henallux.transpLux.dataAccess.dao;

import com.spring.henallux.transpLux.dataAccess.entity.LineItemEntity;
import com.spring.henallux.transpLux.dataAccess.entity.OrderEntity;
import com.spring.henallux.transpLux.model.LineItem;
import com.spring.henallux.transpLux.model.Order;

import java.util.ArrayList;

public interface OrderAccessData {

    void insertNewOrder(Order order, ArrayList<LineItem> items);

}
