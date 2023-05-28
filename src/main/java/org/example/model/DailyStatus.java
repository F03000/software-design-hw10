package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "daily_stats")
public class DailyStatus {
    @Id
    private Long day;

    private Long amount;

    public DailyStatus(Long day, Long amount, Long duration) {
        this.day = day;
        this.amount = amount;
        this.duration = duration;
    }

    private Long duration;

    public Long getDay() {
        return day;
    }

    public void setDay(Long day) {
        this.day = day;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public DailyStatus() {

    }
}
