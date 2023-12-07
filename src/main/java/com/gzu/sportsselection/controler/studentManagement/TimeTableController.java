//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.controler.studentManagement;

import com.gzu.sportsselection.model.sportManagement.Timetable;
import com.gzu.sportsselection.service.sportManagement.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(
        path = {"/api/timetable"}
)
public class TimeTableController {
    private final TimeTableService timeTableService;


    @Autowired
    public TimeTableController(TimeTableService timeTableService ) {
        this.timeTableService = timeTableService;

    }

    @PostMapping({"/save-timeTable"})
    public Timetable saveProperty(@RequestBody Timetable timetable) {
       this.timeTableService.saveTimeTable(timetable);
        return timetable;
    }

    @GetMapping({"/get-all-timeTables"})
    public List<Timetable> getHistories() {
        List<Timetable> histories = this.timeTableService.getTimeTables();
        return histories;
    }


    @GetMapping({"/get-all-timetable/{sportName}"})
    public List<Timetable> getHistoriesBySport(@PathVariable String sportName) {

        List<Timetable> timetables=new ArrayList<>();

        List<Timetable> histories = this.timeTableService.getTimeTables();
        for (Timetable s:histories){
            if (s.getSportName().equals(sportName)){
                timetables.add(s);
            }
        }

        return timetables;
    }


}
