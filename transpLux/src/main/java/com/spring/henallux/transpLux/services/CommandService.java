package com.spring.henallux.transpLux.services;

import com.spring.henallux.transpLux.dataAccess.dao.CommandAccessData;
import com.spring.henallux.transpLux.dataAccess.dao.CommandDAO;
import com.spring.henallux.transpLux.model.LineItem;
import com.spring.henallux.transpLux.model.Command;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CommandService {

    private CommandAccessData commandDAO;

    public CommandService(CommandAccessData orderDAO) {
        this.commandDAO = orderDAO;
    }

    public int insertNewCommand(Command order, ArrayList<LineItem> items) {
        return commandDAO.insertNewCommand(order, items);
    }

    public void validatePayment(int orderId) {
        commandDAO.validatePayment(orderId);
    }

}
