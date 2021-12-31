package com.spring.henallux.transpLux.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "label")
    private String label;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private String price;

    @Column(name = "product_image")
    private String productImage;

    @Column(name = "product_logo")
    private String productLogo;

    @JoinColumn(name = "promotion_id", referencedColumnName = "id")
    @OneToOne
    private PromotionEntity promotion;

    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne
    private CategoryEntity category;


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }



    public PromotionEntity getPromotion() {
        return promotion;
    }

    public void setPromotion(PromotionEntity promotion) {
        this.promotion = promotion;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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
}
