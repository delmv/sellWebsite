package com.spring.henallux.transpLux.model;

import org.hibernate.collection.internal.PersistentBag;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Category {
    private int id;

    private String defaultName;

    private HashMap<String,String> trads;

    private ArrayList<Translation> translations;

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

    public String getNameByLocal(String local){
        return trads.get(local);
    }

    public HashMap<String, String> getTrads() {
        return trads;
    }

    public void setTrads(HashMap<String, String> trads) {
        this.trads = trads;
    }

    public ArrayList<Translation> getTranslations() {
        return translations;
    }

    public void setTranslations(ArrayList<Translation> translations) {
        this.translations = translations;
    }
}
