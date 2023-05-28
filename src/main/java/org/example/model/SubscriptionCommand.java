package org.example.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "subscriptions")
public class SubscriptionCommand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    public SubscriptionCommand(Long userId, LocalDateTime startTime, LocalDateTime endTime, SubscriptionType type) {
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
    }

    private Long userId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private SubscriptionType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public SubscriptionType getType() {
        return type;
    }

    public void setType(SubscriptionType type) {
        this.type = type;
    }

    public SubscriptionCommand() {

    }

    public enum SubscriptionType {
        NEW, EXTENDED
    }
}