package com.spring.henallux.transpLux.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "translation")
public class TranslationEntity {
    @Id
    private Integer id;

    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne
    private CategoryEntity category;

    @JoinColumn(name = "language_id", referencedColumnName = "id")
    @ManyToOne
    private LanguageEntity language;

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }


    public LanguageEntity getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
