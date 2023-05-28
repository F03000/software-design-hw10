package org.example.service;

import org.example.model.SubscriptionCommand;
import org.example.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Service
public class ManagerEventService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public boolean hasLegalSubscription(Long userId) {
        List<SubscriptionCommand> subscriptions = subscriptionRepository.findSubscriptionsByUserIdOrderByEndTime(userId);
        if (subscriptions.isEmpty()) {
            return false;
        }
        SubscriptionCommand subscription = subscriptions.get(subscriptions.size() - 1);
        return subscription.getEndTime().toInstant(ZoneOffset.UTC).toEpochMilli() >= LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();
    }
}
