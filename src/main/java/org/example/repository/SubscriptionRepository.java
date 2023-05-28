package org.example.repository;

import org.example.model.SubscriptionCommand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<SubscriptionCommand, Long> {
    List<SubscriptionCommand> findSubscriptionsByUserIdOrderByEndTime(Long number);
}
