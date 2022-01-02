package com.spring.henallux.transpLux.dataAccess.entity;

import com.spring.henallux.transpLux.model.Translation;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "default_name")
    private String defaultName;

    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    private Collection<TranslationEntity> translations;

    public String getDefaultName() {
        return defaultName;
    }

    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Collection<TranslationEntity> getTranslations() {
        return translations;
    }

    public void setTranslations(Collection<TranslationEntity> translations) {
        this.translations = translations;
    }
}
