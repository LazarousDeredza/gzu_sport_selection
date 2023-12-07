//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.service.sportManagement;

import com.gzu.sportsselection.model.sportManagement.Timetable;
import com.gzu.sportsselection.repository.studentManagement.TimeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeTableService {
    private final TimeTableRepository timeTableRepository;

    @Autowired
    public TimeTableService(TimeTableRepository timeTableRepository) {
        this.timeTableRepository = timeTableRepository;
    }

    public void saveTimeTable(Timetable timetable) {
        this.timeTableRepository.save(timetable);
    }

    public List<Timetable> getTimeTables() {
        return this.timeTableRepository.findAll();
    }



   }
