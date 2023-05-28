package org.example.repository;

import org.example.model.AttendCommand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendRepository extends JpaRepository<AttendCommand, Long> {
}
