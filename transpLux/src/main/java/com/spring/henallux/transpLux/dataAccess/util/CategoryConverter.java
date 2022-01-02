package com.spring.henallux.transpLux.dataAccess.util;

import com.spring.henallux.transpLux.dataAccess.entity.CategoryEntity;
import com.spring.henallux.transpLux.dataAccess.entity.LanguageEntity;
import com.spring.henallux.transpLux.dataAccess.entity.TranslationEntity;
import com.spring.henallux.transpLux.model.Category;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;

@Component
public class CategoryConverter {
    private Mapper mapper = new DozerBeanMapper();

    public CategoryEntity categoryModelToCategoryEntity(Category category) {
        return mapper.map(category, CategoryEntity.class);
    }

    public Category categoryEntityToCategoryModel(CategoryEntity categoryEntity) {
        Category category = new Category();
        HashMap<String,String> trads = new HashMap<>();

        Collection<TranslationEntity> translationEntities =  categoryEntity.getTranslations();

        for(TranslationEntity translationEntity : translationEntities){
            LanguageEntity language = translationEntity.getLanguage();
            String key = language.getName();
            String value = translationEntity.getName();

            trads.put(key, value);
        }
        category.setTrads(trads);
        category.setDefaultName(categoryEntity.getDefaultName());
        category.setId(categoryEntity.getId());

        return category;
    }


}
