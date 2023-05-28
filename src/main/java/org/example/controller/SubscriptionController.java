package org.example.controller;

import org.example.model.SubscriptionCommand;
import org.example.service.SubscriptionCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscriptionController {

    @Autowired
    private SubscriptionCommandService subscriptionCommandService;

    @PostMapping("/subscribe/{userId}")
    public SubscriptionCommand subscribe(@PathVariable Long userId) {
        return subscriptionCommandService.createSubscription(userId);
    }

    @PostMapping("/extend/{userId}")
    public SubscriptionCommand extend(@PathVariable Long userId) {
        return subscriptionCommandService.extendSubscription(userId);
    }
}