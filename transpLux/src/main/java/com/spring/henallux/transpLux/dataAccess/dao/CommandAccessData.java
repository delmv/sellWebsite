package com.spring.henallux.transpLux.dataAccess.dao;

import com.spring.henallux.transpLux.model.LineItem;
import com.spring.henallux.transpLux.model.Command;

import java.util.ArrayList;

public interface CommandAccessData {

    int insertNewCommand(Command order, ArrayList<LineItem> items);
    void validatePayment(int orderId);

}
