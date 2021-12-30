package com.spring.henallux.transpLux.dataAccess.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "promotion")
public class PromotionEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "starting_date")
    private Date startingDate;

    @Column(name = "ending_date")
    private String endingDate;

    @Column(name = "percentage")
    private Integer percentage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public String getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(String endingDate) {
        this.endingDate = endingDate;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }
}
