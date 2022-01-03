package com.spring.henallux.transpLux.dataAccess.entity;

import com.spring.henallux.transpLux.model.LineItem;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "`order`")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "order_date")
    private Date date;

    @Column(name = "is_paid")
    private Boolean isPaid;

    @Column(name = "user_email")
    private String userEmail;

    @OneToMany(targetEntity = LineItemEntity.class, mappedBy = "orderId")
    private List<LineItemEntity> items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<LineItemEntity> getItems() {
        return items;
    }

    public void setItems(List<LineItemEntity> items) {
        this.items = items;
    }
}
