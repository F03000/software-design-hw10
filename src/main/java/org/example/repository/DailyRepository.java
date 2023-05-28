package org.example.repository;

import org.example.model.DailyStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyRepository extends JpaRepository<DailyStatus, Long> {
}
