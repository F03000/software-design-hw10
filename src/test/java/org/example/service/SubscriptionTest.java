package org.example.service;

import org.example.controller.SubscriptionController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SubscriptionTest {

    @Autowired
    private SubscriptionController subscriptionController;


    @Test
    public void subscribe() {
        subscriptionController.subscribe(1L);
    }

    @Test
    public void extendFailed() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> subscriptionController.extend(1L));
    }

    @Test
    public void extendSuccess() {
        subscriptionController.subscribe(1L);
        subscriptionController.extend(1L);
    }


}