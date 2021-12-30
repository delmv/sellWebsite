package com.spring.henallux.transpLux.model;

import javax.validation.constraints.NotBlank;

public class Category {
    private int id;

    private String defaultName;

    public String getDefaultName() {
        return defaultName;
    }

    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
