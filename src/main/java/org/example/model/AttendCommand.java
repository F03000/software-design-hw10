package org.example.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "attends")
public class AttendCommand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private LocalDateTime time;

    @Enumerated(EnumType.STRING)
    private AttendType type;

    public AttendCommand() {
    }

    public AttendCommand(Long userId, LocalDateTime time, AttendType type) {
        this.userId = userId;
        this.time = time;
        this.type = type;
    }

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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public AttendType getType() {
        return type;
    }

    public void setType(AttendType type) {
        this.type = type;
    }

    public enum AttendType {
        ENTER, EXIT
    }
}
