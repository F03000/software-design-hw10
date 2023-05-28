package org.example.service;


import org.example.controller.AttendController;
import org.example.controller.SubscriptionController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AttendCommandServiceTest {

    @Autowired
    private SubscriptionController subscriptionController;

    @Autowired
    private AttendController attendController;


    @Test
    public void attendWithSubscribe() {
        subscriptionController.subscribe(1L);
        Assertions.assertDoesNotThrow(() -> attendController.enter(1L));
        attendController.exit(1L);
    }


    @Test
    public void attendWithNoSubscribe() {
        Assertions.assertThrows(IllegalAccessException.class, () -> {
            attendController.enter(1L);
            attendController.exit(1L);
        });
    }


}

