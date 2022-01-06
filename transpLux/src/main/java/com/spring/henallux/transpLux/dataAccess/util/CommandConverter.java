package com.spring.henallux.transpLux.dataAccess.util;

import com.spring.henallux.transpLux.dataAccess.entity.CommandEntity;
import com.spring.henallux.transpLux.model.Command;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

@Component
public class CommandConverter {

    private Mapper mapper = new DozerBeanMapper();

    public CommandEntity commandModelToCommandEntity(Command order) {
        return mapper.map(order, CommandEntity.class);
    }

    public Command commandEntityToCommandModel(CommandEntity orderEntity) {
        return mapper.map(orderEntity, Command.class);
    }
    
}
