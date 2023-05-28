package org.example.controller;

import org.example.model.AttendCommand;
import org.example.service.AttendCommandService;
import org.example.service.ManagerEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttendController {

    @Autowired
    private AttendCommandService attendCommandService;

    @Autowired
    private ManagerEventService managerEventService;

    @PostMapping("/enter/{userId}")
    public AttendCommand enter(@PathVariable Long userId) throws IllegalAccessException {
        if (managerEventService.hasLegalSubscription(userId)) {
            return attendCommandService.enter(userId);
        } else {
            throw new IllegalAccessException("User has no subscription for id:" + userId);
        }
    }

    @PostMapping("/exit/{userId}")
    public AttendCommand exit(@PathVariable Long userId) {
        return attendCommandService.exit(userId);
    }
}