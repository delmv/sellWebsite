package com.spring.henallux.transpLux.dataAccess.util;

import com.spring.henallux.transpLux.dataAccess.entity.LineItemEntity;
import com.spring.henallux.transpLux.model.LineItem;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class LineItemConverter {

    private Mapper mapper = new DozerBeanMapper();

    public ArrayList<LineItemEntity> lineItemArrayTolineItemEntityArray(ArrayList<LineItem> items) {
        ArrayList<LineItemEntity> itemsEntity = new ArrayList<LineItemEntity>();

        items.forEach(i -> {
            LineItemEntity iEntity = mapper.map(i, LineItemEntity.class);
            itemsEntity.add(iEntity);
        });

        return itemsEntity;
    }

}
