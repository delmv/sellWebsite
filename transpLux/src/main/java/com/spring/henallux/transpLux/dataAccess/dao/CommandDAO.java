package com.spring.henallux.transpLux.dataAccess.dao;

import com.spring.henallux.transpLux.dataAccess.entity.LineItemEntity;
import com.spring.henallux.transpLux.dataAccess.entity.CommandEntity;
import com.spring.henallux.transpLux.dataAccess.repository.LineItemRepository;
import com.spring.henallux.transpLux.dataAccess.repository.CommandRepository;
import com.spring.henallux.transpLux.dataAccess.util.LineItemConverter;
import com.spring.henallux.transpLux.dataAccess.util.CommandConverter;
import com.spring.henallux.transpLux.model.LineItem;
import com.spring.henallux.transpLux.model.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CommandDAO implements CommandAccessData {

    private CommandRepository orderRepository;
    private LineItemRepository lineItemRepository;
    private CommandConverter orderConverter;
    private LineItemConverter lineItemConverter;

    @Autowired
    public CommandDAO(CommandRepository orderRepository, LineItemRepository lineItemRepository, CommandConverter orderConverter, LineItemConverter lineItemConverter) {
        this.orderRepository = orderRepository;
        this.lineItemRepository = lineItemRepository;
        this.orderConverter = orderConverter;
        this.lineItemConverter = lineItemConverter;
    }

    @Override
    public int insertNewCommand(Command order, ArrayList<LineItem> items) {
        CommandEntity orderEntity = orderConverter.commandModelToCommandEntity(order);

        int orderId = orderRepository.save(orderEntity).getId();

        ArrayList<LineItemEntity> itemsEntity = lineItemConverter.lineItemArrayTolineItemEntityArray(items);

        itemsEntity.forEach(i -> i.setOrderId(orderId));

        itemsEntity.forEach(i -> lineItemRepository.save(i));

        return orderId;
    }

    @Override
    public void validatePayment(int orderId) {
        orderRepository.validatePayment(orderId);
    }
}
