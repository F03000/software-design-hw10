package org.example.controller;

import org.example.model.DailyStatus;
import org.example.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping("/update")
    private void update() {
        reportService.update();
    }

    @PostMapping("/dailyStats")
    private List<DailyStatus> dailyStats() {
        return reportService.getDailyStats();
    }
}