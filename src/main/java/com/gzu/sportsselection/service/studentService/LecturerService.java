//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.service.studentService;

import com.gzu.sportsselection.model.sportManagement.Sport;
import com.gzu.sportsselection.model.studentManagement.Lecturer;
import com.gzu.sportsselection.repository.leaseManagement.LeaseRepository;
import com.gzu.sportsselection.repository.sportManagement.SportRepository;
import com.gzu.sportsselection.repository.studentManagement.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecturerService {
    private LecturerRepository lecturerRepository;
    private LeaseRepository leaseRepository;
    private SportRepository sportRepository;

    @Autowired
    public LecturerService(LecturerRepository lecturerRepository, LeaseRepository leaseRepository, SportRepository sportRepository) {
        this.lecturerRepository = lecturerRepository;
        this.leaseRepository = leaseRepository;
        this.sportRepository = sportRepository;
    }

    public Lecturer addLecturer(Lecturer student) {
        return (Lecturer)this.lecturerRepository.save(student);
    }

    public List<Lecturer> addLecturers(List<Lecturer> students) {
        return this.lecturerRepository.saveAll(students);
    }

    public String updateLecturer(Long id, Lecturer student) {
        Lecturer existing_student = (Lecturer)this.lecturerRepository.getById(id);
        existing_student.setPhone(student.getPhone());
        existing_student.setName(student.getName());
        existing_student.setProperty(student.getProperty());
        existing_student.setId_passport(student.getId_passport());
        this.lecturerRepository.save(existing_student);
        return "Tenant updated successfully";
    }

    public List<Lecturer> getAll() {
        return this.lecturerRepository.findAll();
    }

    public List<Lecturer> getAllLecturers() {
        return this.lecturerRepository.findAll();
    }

    public Lecturer getLecturerById(Lecturer student, Long id) {
        Lecturer existing_student = (Lecturer)this.lecturerRepository.getById(id);
        return existing_student;
    }

    public Lecturer getLecturerByID(Long id) {
        return (Lecturer)this.lecturerRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("Lecturer With ID " + id + " Does Not Exist");
        });
    }

    public Lecturer getLecturerByName(Lecturer student, String name) {
        Lecturer existing_student = this.lecturerRepository.getByName(name);
        return existing_student;
    }

    public Lecturer getLecturer(Long id) {
        return (Lecturer)this.lecturerRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("Tenant with id" + id + " does not exist");
        });
    }

    public String updateLecturerSport(Long id, Long sportId) {
        Lecturer existing_student = (Lecturer)this.lecturerRepository.getById(id);

        Sport sport= sportRepository.getById(sportId);
        existing_student.setProperty(sport.getName());
        this.lecturerRepository.save(existing_student);
        return "Lecturer updated successfully";
    }
}
