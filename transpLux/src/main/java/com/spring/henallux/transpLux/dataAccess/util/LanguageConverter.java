package com.spring.henallux.transpLux.dataAccess.util;

import com.spring.henallux.transpLux.dataAccess.entity.LanguageEntity;
import com.spring.henallux.transpLux.model.Language;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

@Component
public class LanguageConverter {
    private Mapper mapper = new DozerBeanMapper();

    public LanguageEntity languageModelToLanguageEntity(Language language) {
        return mapper.map(language, LanguageEntity.class);
    }

    public Language languageEntityToLanguageModel(LanguageEntity languageEntity) {
        return mapper.map(languageEntity, Language.class);
    }
}
