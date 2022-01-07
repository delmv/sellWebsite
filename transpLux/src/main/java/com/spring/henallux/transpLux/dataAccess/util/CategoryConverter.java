package com.spring.henallux.transpLux.dataAccess.util;

import com.spring.henallux.transpLux.dataAccess.entity.CategoryEntity;
import com.spring.henallux.transpLux.dataAccess.entity.LanguageEntity;
import com.spring.henallux.transpLux.dataAccess.entity.TranslationEntity;
import com.spring.henallux.transpLux.model.Category;
import com.spring.henallux.transpLux.model.Translation;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.hibernate.collection.internal.PersistentBag;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Component
public class CategoryConverter {
    private Mapper mapper = new DozerBeanMapper();

    public CategoryEntity categoryModelToCategoryEntity(Category category) {
        return mapper.map(category, CategoryEntity.class);
    }


    public Category categoryEntityToCategoryModel(CategoryEntity categoryEntity) {

        List<TranslationEntity> translations = categoryEntity.getTranslations();
        categoryEntity.setTranslations(null);

        Category category = mapper.map(categoryEntity, Category.class);

        if (translations != null) {
            ArrayList<Translation> translationsModel = new ArrayList<>();
            HashMap<String, String> trads = new HashMap<String, String>();
            translations.forEach(t -> {
                translationsModel.add(mapper.map(t, Translation.class));
                String key = t.getLanguage().getName();
                String value = t.getName();
                trads.put(key, value);
            });

            category.setTranslations(translationsModel);
            category.setTrads(trads);
        }

        return category;
    }

}
