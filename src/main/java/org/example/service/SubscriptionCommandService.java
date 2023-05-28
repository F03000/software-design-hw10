package org.example.service;

import org.example.model.SubscriptionCommand;
import org.example.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SubscriptionCommandService {
    private static final int SUBSCRIPTION_MONTHS_DURATION = 1;
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public SubscriptionCommand createSubscription(Long userId) {
        LocalDateTime now = LocalDateTime.now();

        SubscriptionCommand subscription = new SubscriptionCommand(
                userId,
                now,
                now.plusMonths(SUBSCRIPTION_MONTHS_DURATION),
                SubscriptionCommand.SubscriptionType.NEW
        );

        return subscriptionRepository.save(subscription);
    }

    public SubscriptionCommand extendSubscription(Long userId) {
        List<SubscriptionCommand> subscriptions = subscriptionRepository.findSubscriptionsByUserIdOrderByEndTime(userId);
        if (subscriptions.isEmpty()) {
            throw new IllegalArgumentException("No subscriptions available to extend for user:" + userId);
        }
        LocalDateTime now = LocalDateTime.now();
        SubscriptionCommand subscriptionNew = new SubscriptionCommand(
                userId,
                now,
                now.plusMonths(SUBSCRIPTION_MONTHS_DURATION),
                SubscriptionCommand.SubscriptionType.EXTENDED
        );
        return subscriptionRepository.save(subscriptionNew);
    }
}
