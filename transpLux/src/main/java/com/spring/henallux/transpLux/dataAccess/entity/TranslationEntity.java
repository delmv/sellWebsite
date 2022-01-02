package com.spring.henallux.transpLux.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "translation")
public class TranslationEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "language_id", referencedColumnName = "id")
    @ManyToOne
    private LanguageEntity language;

    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne
    private CategoryEntity category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LanguageEntity getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
