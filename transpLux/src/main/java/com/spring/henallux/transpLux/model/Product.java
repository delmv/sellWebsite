package com.spring.henallux.transpLux.model;

import java.util.Date;

public class Product {
    private int id;

    private String label;

    private String description;

    private Double price;

    private Promotion promotion;

    private Category category;

    private String country;

    private String productImage;

    private String productLogo;

    public Product() {
    }

    public double getCurrentPrice(){
        Date today = new Date();
        if(promotion != null &&
                promotion.getStartingDate().compareTo(today) <= 0 &&
                promotion.getEndingDate().compareTo(today) >= 0){
            return price*(1 - (double)promotion.getPercentage()/100);
        }
        return price;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductLogo() {
        return productLogo;
    }

    public void setProductLogo(String productLogo) {
        this.productLogo = productLogo;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }
}
