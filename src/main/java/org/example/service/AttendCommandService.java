package org.example.service;

import org.example.model.AttendCommand;
import org.example.repository.AttendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AttendCommandService {

    @Autowired
    private AttendRepository attendRepository;

    public AttendCommand enter(Long userId) {
        LocalDateTime now = LocalDateTime.now();
        AttendCommand attendCommand = new AttendCommand(userId, now, AttendCommand.AttendType.ENTER);
        return attendRepository.save(attendCommand);
    }

    public AttendCommand exit(Long userId) {
        LocalDateTime now = LocalDateTime.now();
        AttendCommand attendCommand = new AttendCommand(userId, now, AttendCommand.AttendType.EXIT);
        return attendRepository.save(attendCommand);
    }

    public List<AttendCommand> findAll() {
        return attendRepository.findAll();
    }
}
