package com.spring.henallux.transpLux.dataAccess.util;

import com.spring.henallux.transpLux.dataAccess.entity.PromotionEntity;
import com.spring.henallux.transpLux.model.Promotion;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

@Component
public class PromotionConvertor {

    private Mapper mapper = new DozerBeanMapper();

    public PromotionEntity productModelToProductEntity(Promotion promotion) {
        return mapper.map(promotion, PromotionEntity.class);
    }

    public Promotion productEntityToProductModel(PromotionEntity promotionEntity) {
        return mapper.map(promotionEntity, Promotion.class);
    }

}