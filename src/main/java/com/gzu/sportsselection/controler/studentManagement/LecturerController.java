//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.controler.studentManagement;

import com.gzu.sportsselection.controler.sportManagement.GroundController2;
import com.gzu.sportsselection.model.studentManagement.Lecturer;
import com.gzu.sportsselection.repository.leaseManagement.LeaseRepository;
import com.gzu.sportsselection.service.studentService.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/lecturers"})
public class LecturerController {
    @Autowired
    private LecturerService lecturerService;
    private LeaseRepository leaseRepository;
    private GroundController2 compartmentController;

    @Autowired
    public LecturerController(LecturerService lecturerService, GroundController2 compartmentController) {
        this.lecturerService = lecturerService;
        this.compartmentController = compartmentController;
    }

    @GetMapping({"/get-all-lecturers"})
    public List<Lecturer> getLecturers() {
        List<Lecturer> lecturers = this.lecturerService.getAllLecturers();

        for(int i = 0; i < lecturers.size(); ++i) {
            ((Lecturer) lecturers.get(i)).setCompartmentObjectlist(this.compartmentController.getCompartmentsForSpecificTenant(((Lecturer) lecturers.get(i)).getId()));
        }

        return lecturers;
    }

    @PostMapping({"/addLecturer"})
    public Lecturer addLecturer(@RequestBody Lecturer lecturer) {
        return this.lecturerService.addLecturer(lecturer);
    }

    @PostMapping({"/addlecturers"})
    public List<Lecturer> addLecturers(@RequestBody List<Lecturer> lecturers) {
        return this.lecturerService.addLecturers(lecturers);
    }

    @PutMapping({"/updateLecturer/{id}"})
    public String updateLecturer(@PathVariable Long id, @RequestBody Lecturer lecturer) {
        return this.lecturerService.updateLecturer(id, lecturer);
    }

    @PutMapping({"/updateLecturerSport/{id}/{sport_id}"})
    public String updateLecturerSport(@PathVariable Long id, @PathVariable Long sport_id) {
        return this.lecturerService.updateLecturerSport(id,sport_id);
    }

    @GetMapping({"/getLecturer/{id}"})
    public Lecturer getLecturerById(@RequestBody Lecturer lecturer, @PathVariable Long id) {
        return this.lecturerService.getLecturerById(lecturer, id);
    }

    @GetMapping({"/getLecturerByID/{id}"})
    public Lecturer getLecturerByID(@PathVariable Long id) {
        Lecturer lecturer = this.lecturerService.getLecturerByID(id);
        lecturer.setCompartmentObjectlist(this.compartmentController.getCompartmentsForSpecificTenant(lecturer.getId()));
        return lecturer;
    }

    public Lecturer getLecturer(Long id) {
        return this.lecturerService.getLecturer(id);
    }

    @GetMapping({"/getLecturer/{name}"})
    public Lecturer getLecturerByName(@RequestBody Lecturer student, @PathVariable String name) {
        return this.lecturerService.getLecturerByName(student, name);
    }
}
