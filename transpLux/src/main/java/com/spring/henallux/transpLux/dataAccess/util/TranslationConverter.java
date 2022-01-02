package com.spring.henallux.transpLux.dataAccess.util;

import com.spring.henallux.transpLux.dataAccess.entity.TranslationEntity;
import com.spring.henallux.transpLux.model.Translation;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

@Component
public class TranslationConverter {
    private Mapper mapper = new DozerBeanMapper();

    public TranslationEntity translationModelToTranslationEntity(Translation translation) {
        return mapper.map(translation, TranslationEntity.class);
    }

    public Translation translationEntityToTranslationModel(TranslationEntity translationEntity) {
        return mapper.map(translationEntity, Translation.class);
    }
}
