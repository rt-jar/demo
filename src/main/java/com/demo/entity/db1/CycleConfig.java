package com.demo.entity.db1;

import javax.persistence.*;

@Entity
public class CycleConfig {

    @Id
    @GeneratedValue
    private Long id;

    private String cycleType;
    private String openTime;
    private String closeTime;
    private String cycleCondition;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCycleType() {
        return cycleType;
    }

    public void setCycleType(String cycleType) {
        this.cycleType = cycleType;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getCycleCondition() {
        return cycleCondition;
    }

    public void setCycleCondition(String cycleCondition) {
        this.cycleCondition = cycleCondition;
    }
}
