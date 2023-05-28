package org.example.service;

import org.example.model.AttendCommand;
import org.example.model.DailyStatus;
import org.example.repository.DailyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class ReportService {
    @Autowired
    private DailyRepository dailyRepository;

    @Autowired
    private AttendCommandService attendCommandService;

    public void update() {
        List<AttendCommand> attendance = attendCommandService.findAll();

        HashMap<Long, Map.Entry<Long, Long>> statMap = new HashMap<>();
        for (int i = 0; i < attendance.size(); i++) {
            long duration = 0;
            if (attendance.get(i).getType() == AttendCommand.AttendType.EXIT) {
                for (int j = 0; j < i; j++) {
                    if (attendance.get(i).getType() == AttendCommand.AttendType.ENTER && Objects.equals(attendance.get(i).getUserId(), attendance.get(j).getUserId())) {
                        duration += attendance.get(i).getTime().getSecond() - attendance.get(j).getTime().getSecond();
                    }
                }
            }
            Long current = (long) attendance.get(i).getTime().getDayOfMonth();
            Map.Entry<Long, Long> value = statMap.getOrDefault(current, Map.entry(0L, 0L));
            statMap.put(current, Map.entry(value.getKey() + 1, value.getValue() + duration));

        }

        statMap.replaceAll((k, v) -> Map.entry(v.getKey(), v.getValue() / v.getKey()));

        for (Map.Entry<Long, Map.Entry<Long, Long>> curKey : statMap.entrySet()) {
            dailyRepository.save(new DailyStatus(curKey.getKey(), curKey.getValue().getKey(), curKey.getValue().getValue()));
        }
    }

    public List<DailyStatus> getDailyStats() {
        return dailyRepository.findAll();
    }
}
